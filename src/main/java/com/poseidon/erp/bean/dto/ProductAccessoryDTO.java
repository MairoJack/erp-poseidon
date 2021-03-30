package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 产品 dto
 *
 * @author mario on 2021-01-18
 */
@Getter
@Setter
public class ProductAccessoryDTO extends BaseDTO{

    /**
     * 配件ID
     */
    @NotNull(message = "配件ID不能为空")
    private Long purchaseId;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
    private Integer quantity;
}
