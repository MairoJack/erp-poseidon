package com.poseidon.erp.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.ProductSpu;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 产品Spu 搜索
 *
 * @author mario on 2021-03-26
 */
@Getter
@Setter
public class ProductSpuSearch implements BaseSearch<ProductSpu> {

    @ApiParam(value = "产品名称", name = "name")
    private String name;
    @ApiParam(value = "产品编号", name = "code")
    private String code;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;

    @Override
    public Wrapper<ProductSpu> query() {
        return Wrappers
                .<ProductSpu>lambdaQuery()
                .like(StrUtil.isNotBlank(name), ProductSpu::getName,name)
                .like(StrUtil.isNotBlank(code), ProductSpu::getCode,code)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("create_time", startDate, endDate))
                .orderByDesc(ProductSpu::getId)
        ;
    }
}
