package com.poseidon.erp.bean.vo;

import com.poseidon.erp.bean.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author mario on 2020/5/12
 */
@Getter
@Setter
@AllArgsConstructor
public class SysUserVO {

    private SysUser sysUser;
    /**
     * 角色集合
     */
    private List<String> roles;

    /**
     * 权限集合
     */
    private List<String> permissions;
}
