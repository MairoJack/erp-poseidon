package com.poseidon.erp.service;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.dto.SysRolePermissionDTO;
import com.poseidon.erp.bean.entity.SysRolePermission;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.SysRolePermissionDao;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 角色权限 Service
 *
 * @author mario on 2020-09-30
 */
@Service
@Transactional
public class SysRolePermissionService extends BaseService<SysRolePermissionDao,SysRolePermission, SysRolePermissionDTO> {


    public SysRolePermissionService() {
        super(SysRolePermission.class, ResponseCode.PERMISSION_NOT_FOUND);
    }

    @Override
    protected void checkExist(SysRolePermission sysRolePermission, SysRolePermissionDTO dto) {

    }

    /**
     * 保存角色权限
     */
    public void saveRolePermissions(Long roleId, Long[] permissionIds) {
        this.remove(Wrappers.<SysRolePermission>lambdaQuery().eq(SysRolePermission::getRoleId, roleId));

        if (ArrayUtil.isEmpty(permissionIds)) {
            return;
        }
        List<SysRolePermission> rolePermissionList = Arrays.stream(permissionIds).map(id -> {
            SysRolePermission rolePermission = new SysRolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(id);
            return rolePermission;
        }).collect(Collectors.toList());

        this.saveBatch(rolePermissionList);
    }
}
