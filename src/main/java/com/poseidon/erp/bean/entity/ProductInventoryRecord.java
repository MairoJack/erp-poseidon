package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 产品出入库记录
 *
 * @author mario on 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_product_inventory_record")
public class ProductInventoryRecord extends BaseEntity {


    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 状态(入库、出库)
     */
    private StockStatus status;

    /**
     * 备注
     */
    private String remark;


}
