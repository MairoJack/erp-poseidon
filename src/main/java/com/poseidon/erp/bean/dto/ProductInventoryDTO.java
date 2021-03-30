package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 产品库存 dto
 *
 * @author mario on 2020-12-04
 */
@Getter
@Setter
public class ProductInventoryDTO extends BaseDTO{
    /**
     * 库存数量
     */
    @NotNull(message = "库存数量不能为空")
    private Integer inventory;

}
