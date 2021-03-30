package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.ProductAccessoryDTO;
import com.poseidon.erp.bean.entity.ProductAccessory;
import com.poseidon.erp.bean.search.ProductAccessorySearch;
import com.poseidon.erp.bean.vo.ProductAccessoryVO;
import com.poseidon.erp.service.ProductAccessoryService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品控制器
 *
 * @author mario on 2021-01-18
 */
@Api(value = "产品管理", tags = "产品管理")
@RestController
@RequestMapping("product_accessories")
public class ProductAccessoryController {

    private final ProductAccessoryService service;

    public ProductAccessoryController(ProductAccessoryService service) {
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<ProductAccessory>> page(Page<ProductAccessory> page, ProductAccessorySearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<ProductAccessory>> list(ProductAccessorySearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "列表带库存")
    @GetMapping("list/inventory")
    public R<List<ProductAccessoryVO>> listWithInventory(Long productId) {
        return R.ok(service.listWithInventory(productId));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<ProductAccessory> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated ProductAccessoryDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated ProductAccessoryDTO dto) {
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
