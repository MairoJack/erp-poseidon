package com.poseidon.erp.bean.vo;

import lombok.Data;

/**
 * 产品库存
 *
 * @author mario on 2020-11-27
 */
@Data
public class ProductAccessoryVO {

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 配件ID
     */
    private Long purchaseId;

    /**
     * 配件名称
     */
    private String purchaseName;

    /**
     * 配件编号
     */
    private String purchaseCode;

    /**
     * 配件图片
     */
    private String purchaseImage;

    /**
     * 配件规格
     */
    private String purchaseSpecs;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 库存
     */
    private Integer inventory;


}
