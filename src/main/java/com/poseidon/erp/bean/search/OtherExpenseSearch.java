package com.poseidon.erp.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.OtherExpense;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 其他收支 搜索
 *
 * @author mario on 2020-12-02
 */
@Getter
@Setter
public class OtherExpenseSearch implements BaseSearch<OtherExpense> {

    @ApiParam(value = "收支项目", name = "name")
    private String name;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;

    @Override
    public Wrapper<OtherExpense> query() {
        return Wrappers
                .<OtherExpense>lambdaQuery()
                .like(StrUtil.isNotBlank(name), OtherExpense::getName,name)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("item_time", startDate, endDate))
                .orderByDesc(OtherExpense::getId)
        ;
    }
}
