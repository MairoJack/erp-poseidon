package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.OtherExpenseDTO;
import com.poseidon.erp.bean.entity.OtherExpense;
import com.poseidon.erp.bean.search.OtherExpenseSearch;
import com.poseidon.erp.service.OtherExpenseService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 其他收支控制器
 *
 * @author mario on 2020-12-02
 */
@Api(value = "其他收支管理", tags = "其他收支管理")
@RestController
@RequestMapping("other_expenses")
public class OtherExpenseController {

    private final OtherExpenseService service;

    public OtherExpenseController(OtherExpenseService service){
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<OtherExpense>> page(Page<OtherExpense> page, OtherExpenseSearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<OtherExpense>> list(OtherExpenseSearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<OtherExpense> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated OtherExpenseDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated OtherExpenseDTO dto) {
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
