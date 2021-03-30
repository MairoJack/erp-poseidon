package com.poseidon.erp.bean.vo;

import lombok.Data;

/**
 * 备货记录
 *
 * @author mario on 2020-11-27
 */
@Data
public class StockingRecordVO {

    /**
     * ID
     */
    private Long id;
    /**
     * 备货编号
     */
    private String code;

    /**
     * 产品编号
     */
    private String productCode;
    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品规格
     */
    private String productSpecs;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 完成人员
     */
    private String finishPerson;

    /**
     * 审核人员
     */
    private String operator;

    /**
     * 完成时间
     */
    private String finishTime;

    /**
     * 备注
     */
    private String remark;

}
