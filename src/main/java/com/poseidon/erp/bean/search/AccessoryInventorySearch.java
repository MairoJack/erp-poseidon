package com.poseidon.erp.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.AccessoryInventory;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 原料库存 搜索
 *
 * @author mario on 2020-12-08
 */
@Getter
@Setter
public class AccessoryInventorySearch implements BaseSearch<AccessoryInventory> {

    @ApiParam(value = "采购项编号", name = "purchaseCode")
    private String purchaseCode;
    @ApiParam(value = "采购项名称", name = "purchaseName")
    private String purchaseName;
    @ApiParam(value = "采购项供应商", name = "purchaseSupplier")
    private String purchaseSupplier;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;

    @Override
    public Wrapper<AccessoryInventory> query() {
        return Wrappers
                .<AccessoryInventory>lambdaQuery()
                .like(StrUtil.isNotBlank(purchaseCode), AccessoryInventory::getPurchaseCode,purchaseCode)
                .like(StrUtil.isNotBlank(purchaseName), AccessoryInventory::getPurchaseName,purchaseName)
                .like(StrUtil.isNotBlank(purchaseSupplier), AccessoryInventory::getPurchaseSupplier,purchaseSupplier)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("stock_time", startDate, endDate))
                .orderByDesc(AccessoryInventory::getId)
        ;
    }
}
