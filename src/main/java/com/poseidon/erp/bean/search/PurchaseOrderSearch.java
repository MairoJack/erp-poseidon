package com.poseidon.erp.bean.search;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.PurchaseOrder;
import com.poseidon.erp.bean.enums.StockStatus;
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
public class PurchaseOrderSearch implements BaseSearch<PurchaseOrder> {

    @ApiParam(value = "采购项", name = "name")
    private String name;
    @ApiParam(value = "采购编号", name = "code")
    private String code;
    @ApiParam(value = "采购单号", name = "orderNo")
    private String orderNo;
    @ApiParam(value = "供应商", name = "supplier")
    private String supplier;
    @ApiParam(value = "联系方式", name = "mobile")
    private String mobile;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;
    @ApiParam(value = "是否原料", name = "accessory")
    private Boolean accessory;
    @ApiParam(value = "出入库状态", name = "status")
    private StockStatus status;
    @Override
    public Wrapper<PurchaseOrder> query() {
        return Wrappers
                .<PurchaseOrder>lambdaQuery()
                .like(StrUtil.isNotBlank(name), PurchaseOrder::getName, name)
                .like(StrUtil.isNotBlank(code), PurchaseOrder::getCode, code)
                .likeRight(StrUtil.isNotBlank(orderNo), PurchaseOrder::getOrderNo, orderNo)
                .like(StrUtil.isNotBlank(supplier), PurchaseOrder::getSupplier, supplier)
                .like(StrUtil.isNotBlank(mobile), PurchaseOrder::getMobile, mobile)
                .eq(ObjectUtil.isNotNull(accessory), PurchaseOrder::isAccessory, accessory)
                .eq(ObjectUtil.isNotNull(status), PurchaseOrder::getStatus, status)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("purchase_time", startDate, endDate))
                .orderByDesc(PurchaseOrder::getId)
                ;
    }
}
