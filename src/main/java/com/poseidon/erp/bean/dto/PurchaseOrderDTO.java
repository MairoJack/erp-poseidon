package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 采购项 dto
 *
 * @author mario on 2020-11-18
 */
@Getter
@Setter
public class PurchaseOrderDTO extends BaseDTO {

    /**
     * 采购项
     */
    @NotNull(message = "采购项不能为空")
    private Long purchaseId;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
    private Integer quantity;

    /**
     * 单价
     */
    @NotNull(message = "单价不能为空")
    private BigDecimal unitPrice;

    /**
     * 总价
     */
    @NotNull(message = "总价不能为空")
    private BigDecimal totalPrice;

    /**
     * 采购时间
     */
    @NotNull(message = "采购时间不能为空")
    @JsonFormat(pattern = Constants.DATETIME)
    private LocalDateTime purchaseTime;

    /**
     * 备注
     */
    private String remark;
}
