package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.ProductInventoryRecordDTO;
import com.poseidon.erp.bean.entity.ProductInventoryRecord;
import com.poseidon.erp.bean.search.ProductInventoryRecordSearch;
import com.poseidon.erp.service.ProductInventoryRecordService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品出入库记录控制器
 *
 * @author mario on 2021-02-01
 */
@Api(value = "产品出入库记录管理", tags = "产品出入库记录管理")
@RestController
@RequestMapping("product_inventory_records")
public class ProductInventoryRecordController {

    private final ProductInventoryRecordService service;

    public ProductInventoryRecordController(ProductInventoryRecordService service){
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<ProductInventoryRecord>> page(Page<ProductInventoryRecord> page, ProductInventoryRecordSearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<ProductInventoryRecord>> list(ProductInventoryRecordSearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<ProductInventoryRecord> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated ProductInventoryRecordDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated ProductInventoryRecordDTO dto) {
        service.modify(id, dto);
        return R.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public R<?> delete(@PathVariable Long id) {
        service.delete(id);
        return R.ok();
    }

}
