package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 模具
 *
 * @author mario on 2020-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_mould")
public class Mould extends BaseEntity {


    /**
     * 模具名称
     */
    private String name;

    /**
     * 模具编号
     */
    private String code;

    /**
     * 货架号
     */
    private String shelfNumber;

    /**
     * 开模公司
     */
    private String mouldOpenCompany;

    /**
     * 开模价格
     */
    private BigDecimal mouldOpenPrice;

    /**
     * 开模日期
     */
    private LocalDate mouldOpenDate;

    /**
     * 状态(在库、出库)
     */
    private StockStatus status;

    /**
     * 更新时间
     */
    private LocalDateTime modifyTime;


    /**
     * 备注
     */
    private String remark;


}
