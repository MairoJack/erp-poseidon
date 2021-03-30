package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.PurchaseOrderDTO;
import com.poseidon.erp.bean.entity.PurchaseOrder;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.bean.form.StockForm;
import com.poseidon.erp.bean.search.PurchaseOrderSearch;
import com.poseidon.erp.service.PurchaseOrderService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 采购单控制器
 *
 * @author mario on 2020-11-18
 */
@Api(value = "采购单管理", tags = "采购单管理")
@RestController
@RequestMapping("purchase_orders")
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<PurchaseOrder>> page(Page<PurchaseOrder> page, PurchaseOrderSearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "配件搜索")
    @GetMapping("materials")
    public R<IPage<PurchaseOrder>> materials(Page<PurchaseOrder> page, PurchaseOrderSearch search) {
        search.setAccessory(true);
        search.setStatus(StockStatus.IN_STOCK);
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<PurchaseOrder>> list(PurchaseOrderSearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<PurchaseOrder> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated PurchaseOrderDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated PurchaseOrderDTO dto) {
        service.modify(id, dto);
        return R.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public R<?> delete(@PathVariable Long id) {
        service.delete(id);
        return R.ok();
    }

    @ApiOperation(value = "确认入库")
    @PutMapping("{id}/stock")
    public R<?> stock(@PathVariable Long id, @RequestBody @Validated StockForm form) {
        service.stock(id, form);
        return R.ok();
    }
}
