package com.poseidon.erp.bean.search;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.ProductAccessory;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 产品 搜索
 *
 * @author mario on 2021-01-18
 */
@Getter
@Setter
public class ProductAccessorySearch implements BaseSearch<ProductAccessory> {

    @ApiParam(value = "产品ID", name = "productId")
    private Long productId;

    @Override
    public Wrapper<ProductAccessory> query() {
        return Wrappers
                .<ProductAccessory>lambdaQuery()
                .like(ObjectUtil.isNotNull(productId), ProductAccessory::getProductId, productId)
                ;
    }
}
