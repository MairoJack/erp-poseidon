package com.poseidon.erp.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.Payroll;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 工资单 搜索
 *
 * @author mario on 2020-12-01
 */
@Getter
@Setter
public class PayrollSearch implements BaseSearch<Payroll> {

    @ApiParam(value = "姓名", name = "realname")
    private String realname;
    @ApiParam(value = "联系方式", name = "mobile")
    private String mobile;
    @ApiParam(value = "所属年月", name = "date")
    private String date;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;

    @Override
    public Wrapper<Payroll> query() {
        return Wrappers
                .<Payroll>lambdaQuery()
                .like(StrUtil.isNotBlank(realname), Payroll::getRealname, realname)
                .like(StrUtil.isNotBlank(mobile), Payroll::getMobile, mobile)
                .apply(StrUtil.isNotEmpty(date), dateEqual("date", date))
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("create_time", startDate, endDate))
                .orderByDesc(Payroll::getId)
                ;
    }
}
