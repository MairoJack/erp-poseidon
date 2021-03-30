package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 产品
 *
 * @author mario on 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_product")
public class Product extends BaseEntity {


    /**
     * 产品spuId
     */
    private Long spuId;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品编号
     */
    private String code;

    /**
     * 产品规格
     */
    private String specs;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 产品图片
     */
    private String image;


}
