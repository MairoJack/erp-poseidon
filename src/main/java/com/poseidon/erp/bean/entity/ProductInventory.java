package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 产品库存
 *
 * @author mario on 2020-12-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_product_inventory")
public class ProductInventory extends BaseEntity {


    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 产品编号
     */
    private String productCode;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品图片
     */
    private String productImage;

    /**
     * 产品规格
     */
    private String productSpecs;

    /**
     * 产品备注
     */
    private String productRemark;

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
