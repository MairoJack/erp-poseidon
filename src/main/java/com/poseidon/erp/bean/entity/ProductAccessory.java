package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 产品
 *
 * @author mario on 2021-01-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_product_accessory")
public class ProductAccessory extends BaseEntity {


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


}
