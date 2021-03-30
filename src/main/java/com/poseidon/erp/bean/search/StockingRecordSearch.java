package com.poseidon.erp.bean.search;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.StockingRecord;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 备货记录 搜索
 *
 * @author mario on 2021-01-21
 */
@Getter
@Setter
public class StockingRecordSearch implements BaseSearch<StockingRecord> {

    @ApiParam(value = "备货计划ID", name = "stockingPlanId")
    private Long stockingPlanId;
    @ApiParam(value = "产品名称", name = "productName")
    private String productName;
    @ApiParam(value = "备货编号", name = "batchNo")
    private String code;
    @ApiParam(value = "完成人员", name = "finishPerson")
    private String finishPerson;
    @ApiParam(value = "审批人员", name = "operator")
    private String operator;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;

    @Override
    public Wrapper<StockingRecord> query() {
        return Wrappers
                .<StockingRecord>query()
                .eq(ObjectUtil.isNotNull(stockingPlanId), "sr.stocking_plan_id", stockingPlanId)
                .like(StrUtil.isNotBlank(code), "sp.code", code)
                .like(StrUtil.isNotBlank(productName), "sp.product_name", productName)
                .like(StrUtil.isNotBlank(finishPerson), "sr.finish_person", finishPerson)
                .like(StrUtil.isNotBlank(operator), "sr.operator", operator)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("sr.finish_time", startDate, endDate))
                .orderByDesc("id")
                ;
    }
}
