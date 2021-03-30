package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 返款记录
 *
 * @author mario on 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_payment_record")
public class PaymentRecord extends BaseEntity {


    /**
     *  清单名称
     */
    private String name;

    /**
     * 客户订单号
     */
    private String customerOrderNo;

    /**
     * 总数
     */
    private Integer totalQuantity;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 返款时间
     */
    private LocalDateTime paymentTime;

    /**
     * 备注
     */
    private String remark;


}
