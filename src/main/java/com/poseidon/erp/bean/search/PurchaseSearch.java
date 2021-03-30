package com.poseidon.erp.bean.search;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.Purchase;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 采购项 搜索
 *
 * @author mario on 2020-11-18
 */
@Getter
@Setter
public class PurchaseSearch implements BaseSearch<Purchase> {

    @ApiParam(value = "采购项", name = "name")
    private String name;
    @ApiParam(value = "采购编号", name = "code")
    private String code;
    @ApiParam(value = "供应商", name = "supplier")
    private String supplier;
    @ApiParam(value = "联系方式", name = "mobile")
    private String mobile;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;
    @ApiParam(value = "是否配件", name = "accessory")
    private Boolean accessory;

    @ApiParam(value = "关键词", name = "keyword")
    private String keyword;

    @Override
    public Wrapper<Purchase> query() {
        return Wrappers
                .<Purchase>lambdaQuery()
                .like(StrUtil.isNotBlank(name), Purchase::getName, name)
                .like(StrUtil.isNotBlank(code), Purchase::getCode, code)
                .like(StrUtil.isNotBlank(supplier), Purchase::getSupplier, supplier)
                .like(StrUtil.isNotBlank(mobile), Purchase::getMobile, mobile)
                .eq(ObjectUtil.isNotNull(accessory), Purchase::isAccessory, accessory)
                .like(StrUtil.isNotBlank(keyword), Purchase::getName, keyword)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("create_time", startDate, endDate))
                .orderByDesc(Purchase::getId)
                ;
    }
}
