package com.poseidon.erp.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.Delivery;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 货件 搜索
 *
 * @author mario on 2020-12-04
 */
@Getter
@Setter
public class DeliverySearch implements BaseSearch<Delivery> {

    @ApiParam(value = "货件名称", name = "name")
    private String name;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;


    @Override
    public Wrapper<Delivery> query() {
        return Wrappers
                .<Delivery>lambdaQuery()
                .like(StrUtil.isNotBlank(name), Delivery::getName,name)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("delivery_time", startDate, endDate))
                .orderByDesc(Delivery::getId)
        ;
    }
}
