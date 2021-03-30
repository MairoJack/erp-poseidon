package com.poseidon.erp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.poseidon.erp.bean.entity.SysRole;

import java.util.List;

/**
 * 角色 Dao 接口
 *
 * @author mario on 2020-09-30
 */
public interface SysRoleDao extends BaseMapper<SysRole> {
    List<SysRole> selectByUserId(Long userId);
}
