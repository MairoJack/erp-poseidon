package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

/**
 * 返款记录明细 dto
 *
 * @author mario on 2020-12-10
 */
@Getter
@Setter
public class PaymentRecordDetailDTO extends BaseDTO{

    /**
     * 产品ID
     */
    @NotEmpty(message = "产品ID不能为空")
    private Long productId;

    /**
     * 数量
     */
    private Integer quantity = 0;

    /**
     * 金额
     */
    private BigDecimal amount = BigDecimal.ZERO;
}
