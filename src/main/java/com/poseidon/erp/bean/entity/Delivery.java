package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 货件
 *
 * @author mario on 2020-12-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_delivery")
public class Delivery extends BaseEntity {


    /**
     * 货件名称
     */
    private String name;

    /**
     * 发货货代
     */
    private String deliveryForwarder;

    /**
     * Amazon货件
     */
    private String amazon;

    /**
     * 发货方式
     */
    private String deliveryMethod;

    /**
     * 快递单号
     */
    private String trackingNumber;

    /**
     * 物流费用
     */
    private BigDecimal freight;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 到货时间
     */
    private LocalDateTime arrivalTime;

    /**
     * 是否到货
     */
    @TableField(value = "is_arrival")
    private boolean arrival;

    /**
     * 备注
     */
    private String remark;


}
