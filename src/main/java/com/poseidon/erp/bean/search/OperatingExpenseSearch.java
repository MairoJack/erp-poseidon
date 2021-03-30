package com.poseidon.erp.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.OperatingExpense;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 运营支出 搜索
 *
 * @author mario on 2021-01-18
 */
@Getter
@Setter
public class OperatingExpenseSearch implements BaseSearch<OperatingExpense> {

    @ApiParam(value = "运营项目", name = "name")
    private String name;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;

    @Override
    public Wrapper<OperatingExpense> query() {
        return Wrappers
                .<OperatingExpense>lambdaQuery()
                .like(StrUtil.isNotBlank(name), OperatingExpense::getName,name)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("item_time", startDate, endDate))
                .orderByDesc(OperatingExpense::getId)
        ;
    }
}
