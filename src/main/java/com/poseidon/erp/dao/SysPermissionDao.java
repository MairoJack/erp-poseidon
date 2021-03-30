package com.poseidon.erp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.poseidon.erp.bean.entity.SysPermission;

import java.util.List;

/**
 * 权限 Dao 接口
 *
 * @author mario on 2020-09-30
 */
public interface SysPermissionDao extends BaseMapper<SysPermission> {
    List<String> selectByUserId(Long userId);

    List<Long> selectByRoleId(Long roleId);
}
