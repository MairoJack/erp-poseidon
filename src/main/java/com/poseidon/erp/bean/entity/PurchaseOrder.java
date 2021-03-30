package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 采购单
 *
 * @author mario on 2020-11-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_purchase_order")
public class PurchaseOrder extends BaseEntity {

    /**
     * 采购项ID
     */
    private Long purchaseId;
    /**
     * 采购单号
     */
    private String orderNo;
    /**
     * 采购项
     */
    private String name;

    /**
     * 采购编号
     */
    private String code;

    /**
     * 尺寸规格
     */
    private String specs;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 渠道地址
     */
    private String channelAddress;

    /**
     * 图片
     */
    private String image;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 是否配件
     */
    @TableField(value = "is_accessory")
    private boolean accessory;

    /**
     * 采购时间
     */
    private LocalDateTime purchaseTime;

    /**
     * 入库数量
     */
    private Integer stockQuantity;

    /**
     * 入库时间
     */
    private LocalDateTime stockTime;

    /**
     * 状态
     */
    private StockStatus status;

    /**
     * 备注
     */
    private String remark;


}
