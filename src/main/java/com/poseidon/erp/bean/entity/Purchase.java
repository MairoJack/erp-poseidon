package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 采购项
 *
 * @author mario on 2020-11-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_purchase")
public class Purchase extends BaseEntity {


    /**
     * 采购项
     */
    private String name;

    /**
     * 采购编号
     */
    private String code;

    /**
     * 尺寸规格
     */
    private String specs;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 渠道地址
     */
    private String channelAddress;

    /**
     * 图片
     */
    private String image;

    /**
     * 是否配件
     */
    @TableField(value = "is_accessory")
    private boolean accessory;

    /**
     * 备注
     */
    private String remark;


}
