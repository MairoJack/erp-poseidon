package com.poseidon.erp.service;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.dto.SysUserRoleDTO;
import com.poseidon.erp.bean.entity.SysUserRole;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.SysUserRoleDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 用户角色 Service
 *
 * @author mario on 2020-09-30
 */
@Service
@Transactional
public class SysUserRoleService extends BaseService<SysUserRoleDao,SysUserRole, SysUserRoleDTO > {


    public SysUserRoleService() {
        super(SysUserRole.class, ResponseCode.ROLE_NOT_FOUND);
    }

    @Override
    protected void checkExist(SysUserRole entity, SysUserRoleDTO dto) {

    }

    /**
     * 保存用户角色
     */
    public void saveUserRoles(Long userId, Long[] roles) {
        super.remove(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, userId));

        if (ArrayUtil.isEmpty(roles)) {
            return;
        }
        List<SysUserRole> userRoleList = Arrays.stream(roles).map(id -> {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(id);
            return userRole;
        }).collect(Collectors.toList());

        super.saveBatch(userRoleList);
    }
}
