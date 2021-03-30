package com.poseidon.erp.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.dto.SysUserDTO;
import com.poseidon.erp.bean.entity.SysRole;
import com.poseidon.erp.bean.entity.SysUser;
import com.poseidon.erp.bean.vo.SysUserVO;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.SysUserDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.oauth2.SecurityHolder;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

/**
 * @author mario on 2020/9/21.
 */
@Service
@Transactional
public class SysUserService extends BaseService<SysUserDao, SysUser, SysUserDTO> {

    private final SysRoleService sysRoleService;
    private final SysPermissionService sysPermissionService;
    private final SysUserRoleService sysUserRoleService;


    public SysUserService(SysRoleService sysRoleService, SysPermissionService sysPermissionService, SysUserRoleService sysUserRoleService) {
        super(SysUser.class, ResponseCode.USER_NOT_FOUND);
        this.sysRoleService = sysRoleService;
        this.sysPermissionService = sysPermissionService;
        this.sysUserRoleService = sysUserRoleService;
    }

    @Override
    protected void createExtend(SysUser sysUser) {
        checkRealname(sysUser);
        sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
    }

    @Override
    protected void modifyExtend(SysUser sysUser) {
        checkRealname(sysUser);
        if (StrUtil.isNotEmpty(sysUser.getPassword())) {
            sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        } else {
            sysUser.setPassword(null);
        }
    }

    @Override
    protected void afterCreate(SysUser sysUser, SysUserDTO dto) {
        sysUserRoleService.saveUserRoles(sysUser.getId(), dto.getRoleIds());
    }

    @Override
    protected void afterModify(SysUser sysUser, SysUserDTO dto) {
        sysUserRoleService.saveUserRoles(sysUser.getId(), dto.getRoleIds());
    }

    @Override
    protected void checkExist(SysUser entity, SysUserDTO dto) {
        if (exist(entity.getId(), "username", dto.getUsername())) {
            throw new BusinessException(ResponseCode.USER_NAME_HAS_EXISTED);
        }
        if (exist(entity.getId(), "identity", dto.getIdentity())) {
            throw new BusinessException(ResponseCode.USER_IDENTITY_HAS_EXISTED);
        }
        if (exist(entity.getId(), "mobile", dto.getMobile())) {
            throw new BusinessException(ResponseCode.USER_MOBILE_HAS_EXISTED);
        }
    }

    /**
     * 根据用户名查找
     */
    public SysUser findByUsername(String username) {
        return super.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
    }

    /**
     * 用户信息
     */
    public SysUserVO userInfo() {
        Long id = SecurityHolder.getUser().getId();
        SysUser user = get(id);
        return new SysUserVO(
                user,
                sysRoleService.findByUserId(id).stream().map(SysRole::getCode).collect(Collectors.toList()),
                sysPermissionService.findByUserId(id));
    }

    /**
     * 分配角色
     */
    private void assignRole(Long userId, Long[] roleIds) {
        sysUserRoleService.saveUserRoles(userId, roleIds);
    }

    /**
     * 检查姓名重复，如果重复补手机号后4位
     */
    private void checkRealname(SysUser sysUser) {
        if (exist(sysUser.getId(), "realname", sysUser.getRealname())) {
            sysUser.setRealname(sysUser.getRealname() + StrUtil.subSuf(sysUser.getMobile(), -4));
        }
    }

}
