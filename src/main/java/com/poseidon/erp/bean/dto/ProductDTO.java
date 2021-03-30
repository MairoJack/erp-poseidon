package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 产品 dto
 *
 * @author mario on 2020-11-05
 */
@Getter
@Setter
public class ProductDTO extends BaseDTO {

    /**
     * 产品SPU
     */
    private Long spuId;

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
     * 产品规格
     */
    @NotEmpty(message = "产品规格不能为空")
    private String specs;

    /**
     * 产品图片
     */
    private String image;

    /**
     * 产品数量
     */
    @NotNull(message = "产品数量不能为空")
    private Integer quantity;

    /**
     * 备注
     */
    private String remark;

    /**
     * 配件信息
     */
    private List<ProductAccessoryDTO> details;
}
