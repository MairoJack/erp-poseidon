package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.CrossBorderIncomeDTO;
import com.poseidon.erp.bean.entity.CrossBorderIncome;
import com.poseidon.erp.bean.search.CrossBorderIncomeSearch;
import com.poseidon.erp.service.CrossBorderIncomeService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 跨境返款控制器
 *
 * @author mario on 2021-01-18
 */
@Api(value = "跨境返款管理", tags = "跨境返款管理")
@RestController
@RequestMapping("cross_border_incomes")
public class CrossBorderIncomeController {

    private final CrossBorderIncomeService service;

    public CrossBorderIncomeController(CrossBorderIncomeService service){
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<CrossBorderIncome>> page(Page<CrossBorderIncome> page, CrossBorderIncomeSearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<CrossBorderIncome>> list(CrossBorderIncomeSearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<CrossBorderIncome> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated CrossBorderIncomeDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated CrossBorderIncomeDTO dto) {
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
