package com.poseidon.erp.bean.search;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.Product;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 产品 搜索
 *
 * @author mario on 2020-11-05
 */
@Getter
@Setter
public class ProductSearch implements BaseSearch<Product> {

    @ApiParam(value = "产品名称", name = "name")
    private String name;
    @ApiParam(value = "产品编号", name = "code")
    private String code;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;
    @ApiParam(value = "产品spuId", name = "spuId")
    private String spuId;

    @ApiParam(value = "关键词", name = "keyword")
    private String keyword;

    @Override
    public Wrapper<Product> query() {
        return Wrappers
                .<Product>lambdaQuery()
                .like(StrUtil.isNotBlank(keyword), Product::getName, keyword)
                .like(StrUtil.isNotBlank(name), Product::getName, name)
                .like(StrUtil.isNotBlank(code), Product::getCode, code)
                .like(ObjectUtil.isNotNull(spuId), Product::getSpuId, spuId)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("create_time", startDate, endDate))
                .orderByDesc(Product::getId)
                ;
    }
}
