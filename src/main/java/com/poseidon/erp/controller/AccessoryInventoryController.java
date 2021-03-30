package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.AccessoryInventoryDTO;
import com.poseidon.erp.bean.entity.AccessoryInventory;
import com.poseidon.erp.bean.search.AccessoryInventorySearch;
import com.poseidon.erp.service.AccessoryInventoryService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 配件库存控制器
 *
 * @author mario on 2020-12-08
 */
@Api(value = "配件库存管理", tags = "配件库存管理")
@RestController
@RequestMapping("accessory_inventories")
public class AccessoryInventoryController {

    private final AccessoryInventoryService service;

    public AccessoryInventoryController(AccessoryInventoryService service){
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<AccessoryInventory>> page(Page<AccessoryInventory> page, AccessoryInventorySearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<AccessoryInventory>> list(AccessoryInventorySearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<AccessoryInventory> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated AccessoryInventoryDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated AccessoryInventoryDTO dto) {
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
