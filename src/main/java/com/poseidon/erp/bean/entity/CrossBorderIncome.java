package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 跨境返款
 *
 * @author mario on 2021-01-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_cross_border_income")
public class CrossBorderIncome extends BaseEntity {


    /**
     * 返款项目
     */
    private String name;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 美金金额
     */
    private BigDecimal amountUsd;

    /**
     * 备注
     */
    private String remark;

    /**
     * 项目时间
     */
    private LocalDateTime itemTime;


}
