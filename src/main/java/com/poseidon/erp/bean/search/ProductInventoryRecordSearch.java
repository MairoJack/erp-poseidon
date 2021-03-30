package com.poseidon.erp.bean.search;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.ProductInventoryRecord;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 原料使用记录 搜索
 *
 * @author mario on 2021-02-01
 */
@Getter
@Setter
public class ProductInventoryRecordSearch implements BaseSearch<ProductInventoryRecord> {

    @ApiParam(value = "产品ID", name = "productId")
    private Long productId;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;
    @Override
    public Wrapper<ProductInventoryRecord> query() {
        return Wrappers
                .<ProductInventoryRecord>lambdaQuery()
                .like(ObjectUtil.isNotNull(productId), ProductInventoryRecord::getProductId, productId)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("create_time", startDate, endDate))
                .orderByDesc(ProductInventoryRecord::getId)
                ;
    }
}
