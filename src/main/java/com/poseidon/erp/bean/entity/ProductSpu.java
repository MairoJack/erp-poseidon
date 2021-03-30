package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 产品SPU
 *
 * @author mario on 2021-03-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_product_spu")
public class ProductSpu extends BaseEntity {


    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品编号
     */
    private String code;

    /**
     * 产品品牌
     */
    private String brand;

    /**
     * 备注
     */
    private String remark;

    /**
     * 产品图片
     */
    private String image;


}
