package com.poseidon.erp.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mario on 2020/9/21.
 */
@AllArgsConstructor
public class BaseController<T extends BaseEntity,
        DTO extends BaseDTO,
        S extends IBaseService<T, DTO>,
        SEARCH extends BaseSearch<T>
        > {

    private final S service;

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<T>> page(Page<T> page, SEARCH search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<T>> list(SEARCH search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<T> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated DTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated DTO dto) {
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
