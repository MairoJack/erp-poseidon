package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 角色权限
 *
 * @author mario on 2020-09-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_sys_role_permission")
public class SysRolePermission extends BaseEntity {

    /**
     * 权限ID
     */
    private Long permissionId;

    /**
     * 角色ID
     */
    private Long roleId;



}
