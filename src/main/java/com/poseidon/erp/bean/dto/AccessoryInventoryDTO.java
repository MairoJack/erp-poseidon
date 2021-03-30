package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 配件库存 dto
 *
 * @author mario on 2020-12-08
 */
@Getter
@Setter
public class AccessoryInventoryDTO extends BaseDTO{

    /**
     * 库存数量
     */
    @NotNull(message = "库存数量不能为空")
    private Integer inventory;

}
