package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 货件明细
 *
 * @author mario on 2020-12-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_delivery_detail")
public class DeliveryDetail extends BaseEntity {


    /**
     * 货件ID
     */
    private Long deliveryId;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品编号
     */
    private String productCode;

    /**
     * 产品规格
     */
    private String productSpecs;

    /**
     * 数量
     */
    private Integer quantity;


}
