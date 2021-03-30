package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.bean.enums.PermissionType;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 权限
 *
 * @author mario on 2020-09-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_sys_permission")
public class SysPermission extends BaseEntity {

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限编码
     */
    private String code;

    /**
     * 权限描述
     */
    private String description;
    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 类型(菜单,按钮)
     */
    private PermissionType type;

}
