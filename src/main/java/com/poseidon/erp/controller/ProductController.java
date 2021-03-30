package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.ProductDTO;
import com.poseidon.erp.bean.entity.Product;
import com.poseidon.erp.bean.search.ProductSearch;
import com.poseidon.erp.bean.vo.ProductVO;
import com.poseidon.erp.service.ProductService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品控制器
 *
 * @author mario on 2020-11-05
 */
@Api(value = "产品管理", tags = "产品管理")
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<Product>> page(Page<Product> page, ProductSearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<Product>> list(ProductSearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情带明细")
    @GetMapping("{id}")
    public R<ProductVO> detail(@PathVariable Long id) {
        return R.ok(service.detail(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated ProductDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated ProductDTO dto) {
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
