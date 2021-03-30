package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 原料使用记录
 *
 * @author mario on 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_accessory_use_record")
public class AccessoryUseRecord extends BaseEntity {


    /**
     * 采购项ID
     */
    private Long purchaseId;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 执行状态(在库、出库)
     */
    private StockStatus status;

    /**
     * 备注
     */
    private String remark;


}
