package com.poseidon.erp.bean.vo;

import com.poseidon.erp.bean.entity.Product;
import com.poseidon.erp.bean.entity.ProductAccessory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author mario on 2020/5/12
 */
@Getter
@Setter
@AllArgsConstructor
public class ProductVO {

    private Product product;
    private List<ProductAccessory> details;
}
