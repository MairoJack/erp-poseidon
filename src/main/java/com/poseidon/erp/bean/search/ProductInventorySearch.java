package com.poseidon.erp.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.ProductInventory;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 产品库存 搜索
 *
 * @author mario on 2020-12-04
 */
@Getter
@Setter
public class ProductInventorySearch implements BaseSearch<ProductInventory> {


    @ApiParam(value = "产品编号", name = "productCode")
    private String productCode;
    @ApiParam(value = "产品名称", name = "productName")
    private String productName;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;

    @Override
    public Wrapper<ProductInventory> query() {
        return Wrappers
                .<ProductInventory>lambdaQuery()
                .like(StrUtil.isNotBlank(productCode), ProductInventory::getProductCode,productCode)
                .like(StrUtil.isNotBlank(productName), ProductInventory::getProductName,productName)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("stock_time", startDate, endDate))
                .orderByDesc(ProductInventory::getId)
        ;
    }
}
