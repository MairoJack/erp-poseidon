package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 模具 dto
 *
 * @author mario on 2020-11-17
 */
@Getter
@Setter
public class MouldDTO extends BaseDTO{

    /**
     * 模具名称
     */
    @NotEmpty(message = "模具名称不能为空")
    private String name;

    /**
     * 模具编号
     */
    @NotEmpty(message = "模具编号不能为空")
    private String code;

    /**
     * 货架号
     */
    @NotEmpty(message = "货架号不能为空")
    private String shelfNumber;

    /**
     * 开模公司
     */
    @NotEmpty(message = "开模公司不能为空")
    private String mouldOpenCompany;

    /**
     * 开模价格
     */
    @NotNull(message = "开模价格不能为空")
    private BigDecimal mouldOpenPrice;

    /**
     * 开模日期
     */
    @NotNull(message = "开模日期不能为空")
    @JsonFormat(pattern = Constants.DATE)
    private LocalDate mouldOpenDate;

    /**
     * 备注
     */
    private String remark;
}
