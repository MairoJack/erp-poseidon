package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 跨境返款 dto
 *
 * @author mario on 2021-01-18
 */
@Getter
@Setter
public class CrossBorderIncomeDTO extends BaseDTO{

    /**
     * 运营项目
     */
    @NotEmpty(message = "返款项目不能为空")
    private String name;

    /**
     * 金额
     */
    @NotNull(message = "金额不能为空")
    private BigDecimal amount;

    /**
     * 美金金额
     */
    @NotNull(message = "美金金额不能为空")
    private BigDecimal amountUsd;

    /**
     * 备注
     */
    private String remark;

    /**
     * 返款时间
     */
    @NotNull(message = "返款时间不能为空")
    @JsonFormat(pattern = Constants.DATETIME)
    private LocalDateTime itemTime;
}
