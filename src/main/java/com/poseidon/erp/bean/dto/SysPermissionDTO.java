package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * 权限 dto
 *
 * @author mario on 2020-09-30
 */
@Getter
@Setter
public class SysPermissionDTO extends BaseDTO{

    /**
     * 权限名
     */
    @NotEmpty(message = "不能为空")
    private String name;

    /**
     * 权限编码
     */
    @NotEmpty(message = "不能为空")
    private String code;

    /**
     * 权限描述
     */
    private String description;
}
