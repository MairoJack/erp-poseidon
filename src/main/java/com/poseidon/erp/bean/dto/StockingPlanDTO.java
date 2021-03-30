package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * 备货计划 dto
 *
 * @author mario on 2021-01-20
 */
@Getter
@Setter
public class StockingPlanDTO extends BaseDTO{

    /**
     * 产品ID
     */
    @NotNull(message = "产品ID不能为空")
    private Long productId;

    /**
     * 备货数量
     */
    @NotNull(message = "备货数量不能为空")
    private Integer quantity;

    /**
     * 交付日期
     */
    @NotNull(message = "交付日期不能为空")
    @JsonFormat(pattern = Constants.DATE)
    private LocalDate deliveryDate;

    /**
     * 备货备注
     */
    private String remark;
}
