package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poseidon.erp.bean.enums.Sex;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author mario on 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_sys_user")
public class SysUser extends BaseEntity {


    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 身份证
     */
    private String identity;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastTime;

    /**
     * 姓名
     */
    private String realname;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 性别:男,女
     */
    private Sex sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 入职时间
     */
    private LocalDate entryDate;

}
