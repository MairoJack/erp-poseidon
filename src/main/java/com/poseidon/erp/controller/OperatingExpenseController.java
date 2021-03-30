package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.OperatingExpenseDTO;
import com.poseidon.erp.bean.entity.OperatingExpense;
import com.poseidon.erp.bean.search.OperatingExpenseSearch;
import com.poseidon.erp.service.OperatingExpenseService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 运营支出控制器
 *
 * @author mario on 2021-01-18
 */
@Api(value = "运营支出管理", tags = "运营支出管理")
@RestController
@RequestMapping("operating_expenses")
public class OperatingExpenseController {

    private final OperatingExpenseService service;

    public OperatingExpenseController(OperatingExpenseService service){
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<OperatingExpense>> page(Page<OperatingExpense> page, OperatingExpenseSearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<OperatingExpense>> list(OperatingExpenseSearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<OperatingExpense> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated OperatingExpenseDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated OperatingExpenseDTO dto) {
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
