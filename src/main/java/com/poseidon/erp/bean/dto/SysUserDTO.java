package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.bean.enums.Sex;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import com.poseidon.erp.common.Create;
import com.poseidon.erp.common.Update;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * dto
 *
 * @author mario on 2020-10-26
 */
@Getter
@Setter
public class SysUserDTO extends BaseDTO {

    /**
     * 用户名
     */
    @NotEmpty(message = "账号不能为空", groups = {Create.class, Update.class})
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空", groups = Create.class)
    private String password;

    /**
     * 姓名
     */
    @NotEmpty(message = "姓名不能为空", groups = {Create.class, Update.class})
    private String realname;

    /**
     * 联系方式
     */
    @NotEmpty(message = "联系方式不能为空", groups = {Create.class, Update.class})
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
     * 头像
     */
    private String avatar;

    /**
     * 身份证
     */
    @NotEmpty(message = "身份证不能为空", groups = {Create.class, Update.class})
    private String identity;

    /**
     * 角色id数组
     */
    private Long[] roleIds;

    /**
     * 入职日期
     */
    @NotNull(message = "入职日期不能为空", groups = {Create.class, Update.class})
    @JsonFormat(pattern = Constants.DATE)
    private LocalDate entryDate;

}
