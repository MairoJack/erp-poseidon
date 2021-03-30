package com.poseidon.erp.bean.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 分配权限
 *
 * @author mario on 2020-09-27
 */
@Getter
@Setter
public class AssignPermissionForm {

    /**
     * 角色id
     */
    @NotNull(message = "角色id不能为空")
    private Long roleId;

    /**
     * 权限id数组
     */
    private Long[] permissionIds;

}
