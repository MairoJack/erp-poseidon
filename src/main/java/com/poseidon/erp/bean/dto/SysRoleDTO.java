package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
/**
 *  dto
 *
 * @author mario on 2020-09-30
 */
@Getter
@Setter
public class SysRoleDTO extends BaseDTO{

    /**
     * 角色名
     */
    @NotEmpty(message = "不能为空")
    private String name;

    /**
     * 角色编码
     */
    @NotEmpty(message = "不能为空")
    private String code;

    /**
     * 角色描述
     */
    @NotEmpty(message = "不能为空")
    private String description;
}
