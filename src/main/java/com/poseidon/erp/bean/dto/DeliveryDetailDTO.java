package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 货件明细 dto
 *
 * @author mario on 2020-12-04
 */
@Getter
@Setter
public class DeliveryDetailDTO extends BaseDTO {

    /**
     * 产品ID
     */
    @NotNull(message = "产品ID不能为空")
    private Long productId;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
    private Integer quantity;
}
