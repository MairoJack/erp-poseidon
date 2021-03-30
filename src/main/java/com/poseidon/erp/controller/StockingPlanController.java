package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.StockingPlanDTO;
import com.poseidon.erp.bean.entity.StockingPlan;
import com.poseidon.erp.bean.form.StockForm;
import com.poseidon.erp.bean.search.StockingPlanSearch;
import com.poseidon.erp.service.StockingPlanService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 备货计划控制器
 *
 * @author mario on 2021-01-20
 */
@Api(value = "备货计划管理", tags = "备货计划管理")
@RestController
@RequestMapping("stocking_plans")
public class StockingPlanController {

    private final StockingPlanService service;

    public StockingPlanController(StockingPlanService service){
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<StockingPlan>> page(Page<StockingPlan> page, StockingPlanSearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<StockingPlan>> list(StockingPlanSearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<StockingPlan> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated StockingPlanDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated StockingPlanDTO dto) {
        service.modify(id, dto);
        return R.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public R<?> delete(@PathVariable Long id) {
        service.delete(id);
        return R.ok();
    }

    @ApiOperation(value = "完成")
    @PutMapping("{id}/finish")
    public R<?> finish(@PathVariable Long id) {
        service.finish(id);
        return R.ok();
    }

    @ApiOperation(value = "入库")
    @PutMapping("{id}/stock")
    public R<?> stock(@PathVariable Long id, @RequestBody @Validated StockForm form) {
        service.stock(id, form);
        return R.ok();
    }

    @ApiOperation(value = "统计入库总量")
    @GetMapping("statistics/stock_quantity")
    public R<BigDecimal> statistics(StockingPlanSearch search) {
        return R.ok(service.statisticsStockQuantity(search));
    }
}
