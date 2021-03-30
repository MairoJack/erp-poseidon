package com.poseidon.erp.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.StockingPlan;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 备货计划 搜索
 *
 * @author mario on 2021-01-20
 */
@Getter
@Setter
public class StockingPlanSearch implements BaseSearch<StockingPlan> {

    @ApiParam(value = "备货编号", name = "code")
    private String code;
    @ApiParam(value = "产品名称", name = "productName")
    private String productName;
    @ApiParam(value = "产品编号", name = "productCode")
    private String productCode;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;

    @Override
    public Wrapper<StockingPlan> query() {
        return Wrappers
                .<StockingPlan>lambdaQuery()
                .like(StrUtil.isNotBlank(code), StockingPlan::getCode,code)
                .like(StrUtil.isNotBlank(productName), StockingPlan::getProductName,productName)
                .like(StrUtil.isNotBlank(productCode), StockingPlan::getProductCode,productCode)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("create_time", startDate, endDate))
                .orderByDesc(StockingPlan::getId)
        ;
    }
}
