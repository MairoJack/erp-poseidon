package com.poseidon.erp.service;

import com.google.common.collect.Lists;
import com.poseidon.erp.bean.dto.SysPermissionDTO;
import com.poseidon.erp.bean.entity.SysPermission;
import com.poseidon.erp.bean.form.AssignPermissionForm;
import com.poseidon.erp.bean.vo.TreeNode;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.SysPermissionDao;
import com.poseidon.erp.utils.Assert;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Service
 *
 * @author mario on 2020-09-30
 */
@Transactional
@Service
public class SysPermissionService extends BaseService<SysPermissionDao, SysPermission, SysPermissionDTO> {

    private final SysRoleService sysRoleService;
    private final SysRolePermissionService sysRolePermissionService;

    public SysPermissionService(SysRoleService sysRoleService, SysRolePermissionService sysRolePermissionService) {
        super(SysPermission.class, ResponseCode.PERMISSION_NOT_FOUND);
        this.sysRoleService = sysRoleService;
        this.sysRolePermissionService = sysRolePermissionService;
    }

    @Override
    protected void checkExist(SysPermission entity, SysPermissionDTO dto) {

    }

    /**
     * 根据用户ID查找权限列表
     */
    public List<String> findByUserId(Long userId) {
        return baseMapper.selectByUserId(userId);
    }

    public List<TreeNode> getTree() {
        List<SysPermission> list = baseMapper.selectList(null);
        return buildTree(list);
    }

    public List<Long> getRoleList(Long roleId) {
        return baseMapper.selectByRoleId(roleId);
    }

    /**
     * 构建权限树
     */
    private List<TreeNode> buildTree(List<SysPermission> list) {
        List<TreeNode> trees = Lists.newArrayList();
        for (SysPermission permission : list) {
            if (permission.getParentId() == 0) {
                TreeNode tree = build(permission);
                trees.add(children(list, tree));
                tree.setHasChildren(true);
            }
        }
        return trees;
    }

    /**
     * 递归查询子节点
     */
    private TreeNode children(List<SysPermission> list, TreeNode parent) {
        for (SysPermission p : list) {
            if (p.getParentId().equals(parent.getId())) {
                if (parent.getChildren() == null) {
                    parent.setChildren(Lists.newArrayList());
                }
                TreeNode child = build(p);
                parent.getChildren().add(children(list, child));
            }
        }
        return parent;
    }

    /**
     * 构建树节点
     */
    private TreeNode build(SysPermission permission) {
        TreeNode node = new TreeNode();
        node.setId(permission.getId());
        node.setParentId(permission.getParentId());
        node.setName(permission.getName());
        node.setType(permission.getType());
        return node;
    }

    /**
     * 分配权限
     */
    public void assign(AssignPermissionForm form) {
        Long roleId = form.getRoleId();
        Assert.notFound(sysRoleService.get(roleId), ResponseCode.ROLE_NOT_FOUND);
        sysRolePermissionService.saveRolePermissions(roleId, form.getPermissionIds());
    }
}
