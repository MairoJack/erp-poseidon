package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.StockingRecordDTO;
import com.poseidon.erp.bean.entity.StockingRecord;
import com.poseidon.erp.bean.search.StockingRecordSearch;
import com.poseidon.erp.bean.vo.StockingRecordVO;
import com.poseidon.erp.service.StockingRecordService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 备货记录控制器
 *
 * @author mario on 2021-01-21
 */
@Api(value = "备货记录管理", tags = "备货记录管理")
@RestController
@RequestMapping("stocking_records")
public class StockingRecordController {

    private final StockingRecordService service;

    public StockingRecordController(StockingRecordService service){
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<StockingRecordVO>> page(Page<StockingRecord> page, StockingRecordSearch search) {
        return R.ok(service.stockingRecordPage(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<StockingRecordVO>> list(StockingRecordSearch search) {
        return R.ok(service.stockingRecordList(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<StockingRecord> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated StockingRecordDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated StockingRecordDTO dto) {
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
