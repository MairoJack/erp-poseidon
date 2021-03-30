package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 原料库存
 *
 * @author mario on 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_accessory_inventory")
public class AccessoryInventory extends BaseEntity {


    /**
     * 采购项ID
     */
    private Long purchaseId;

    /**
     * 采购项编号
     */
    private String purchaseCode;

    /**
     * 采购项图片
     */
    private String purchaseImage;

    /**
     * 采购项名称
     */
    private String purchaseName;

    /**
     * 采购项供应商
     */
    private String purchaseSupplier;

    /**
     * 使用量
     */
    private Integer useQuantity;

    /**
     * 库存数量
     */
    private Integer inventory;

    /**
     * 历史总量
     */
    private Integer historyInventory;

    /**
     * 入库时间
     */
    private LocalDateTime stockTime;

}
