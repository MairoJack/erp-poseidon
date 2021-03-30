package com.poseidon.erp.bean.vo;

import lombok.Data;

/**
 * 产品库存
 *
 * @author mario on 2020-11-27
 */
@Data
public class ProductInventoryVO {

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品名称
     */
    private String productCode;

    /**
     * 产品规格
     */
    private String productSpecs;

    /**
     * 库存
     */
    private int inventory;

    /**
     * 数量
     */
    private int quantity;



}
