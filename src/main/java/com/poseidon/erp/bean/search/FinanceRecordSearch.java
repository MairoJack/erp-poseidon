package com.poseidon.erp.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.FinanceRecord;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 财务记录 搜索
 *
 * @author mario on 2020-12-11
 */
@Getter
@Setter
public class FinanceRecordSearch implements BaseSearch<FinanceRecord> {

    @ApiParam(value = "项目名称", name = "name")
    private String name;
    @ApiParam(value = "类型(采购、原料、工资、销售额、其他)", name = "type")
    private String type;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;

    @Override
    public Wrapper<FinanceRecord> query() {
        return Wrappers
                .<FinanceRecord>lambdaQuery()
                .like(StrUtil.isNotBlank(name), FinanceRecord::getName, name)
                .like(StrUtil.isNotBlank(type), FinanceRecord::getType, type)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("create_time", startDate, endDate))
                .orderByDesc(FinanceRecord::getId)
                ;
    }
}
