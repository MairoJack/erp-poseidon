package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
/**
 * 采购项 dto
 *
 * @author mario on 2020-11-18
 */
@Getter
@Setter
public class PurchaseDTO extends BaseDTO{

    /**
     * 采购项
     */
    @NotEmpty(message = "采购项不能为空")
    private String name;

    /**
     * 采购编号
     */
    @NotEmpty(message = "采购编号不能为空")
    private String code;

    /**
     * 尺寸规格
     */
    @NotEmpty(message = "尺寸规格不能为空")
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
     * 是否配件
     */
    private boolean accessory;

    /**
     * 采购项图片
     */
    private String image;

    /**
     * 备注
     */
    private String remark;
}
