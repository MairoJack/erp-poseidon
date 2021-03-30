package com.poseidon.erp.bean.entity;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 工资单
 *
 * @author mario on 2020-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_payroll")
public class Payroll extends BaseEntity {


    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 姓名
     */
    private String realname;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 所属年月
     */
    private LocalDate date;

    /**
     * 基本工资
     */
    private BigDecimal basicSalary;

    /**
     * 加班工资
     */
    private BigDecimal overtimeSalary;

    /**
     * 补贴
     */
    private BigDecimal subsidy;

    /**
     * 考勤
     */
    private BigDecimal attendance;

    /**
     * 其他
     */
    private BigDecimal other;

    /**
     * 合计
     */
    private BigDecimal total;

    /**
     * 备注
     */
    private String remark;

    /**
     * 汇总
     */
    public void summary() {
        this.total = NumberUtil.add(this.basicSalary, this.overtimeSalary, this.subsidy, this.attendance, this.other);
    }

}
