package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * 用户角色 dto
 *
 * @author mario on 2020-09-30
 */
@Getter
@Setter
public class SysUserRoleDTO extends BaseDTO{

    /**
     * 角色名
     */
    @NotEmpty(message = "角色名不能为空")
    private String name;

    /**
     * 角色编码
     */
    @NotEmpty(message = "角色编码不能为空")
    private String code;

    /**
     * 角色描述
     */
    private String description;
}
