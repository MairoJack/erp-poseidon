package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 产品SPU dto
 *
 * @author mario on 2021-03-26
 */
@Getter
@Setter
public class ProductSpuDTO extends BaseDTO {

    /**
     * 产品名称
     */
    @NotEmpty(message = "产品名称不能为空")
    private String name;

    /**
     * 产品编号
     */
    @NotEmpty(message = "产品编号不能为空")
    private String code;

    /**
     * 产品品牌
     */
    @NotEmpty(message = "产品品牌不能为空")
    private String brand;

    /**
     * 备注
     */
    private String remark;

    /**
     * 产品子体信息
     */
    private List<ProductDTO> products;
}
