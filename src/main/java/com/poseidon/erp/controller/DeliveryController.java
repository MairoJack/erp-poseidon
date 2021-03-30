package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.DeliveryDTO;
import com.poseidon.erp.bean.entity.Delivery;
import com.poseidon.erp.bean.search.DeliverySearch;
import com.poseidon.erp.common.Create;
import com.poseidon.erp.common.Update;
import com.poseidon.erp.service.DeliveryService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 货件控制器
 *
 * @author mario on 2020-12-04
 */
@Api(value = "货件管理", tags = "货件管理")
@RestController
@RequestMapping("deliveries")
public class DeliveryController {

    private final DeliveryService service;

    public DeliveryController(DeliveryService service) {
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<Delivery>> page(Page<Delivery> page, DeliverySearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<Delivery>> list(DeliverySearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<Delivery> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated(Create.class) DeliveryDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated(Update.class) DeliveryDTO dto) {
        service.modify(id, dto);
        return R.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public R<?> delete(@PathVariable Long id) {
        service.delete(id);
        return R.ok();
    }

    @ApiOperation(value = "确认到货")
    @PutMapping("{id}/arrival")
    public R<?> arrival(@PathVariable Long id, @RequestBody  DeliveryDTO dto) {
        service.arrival(id, dto.getArrivalTime());
        return R.ok();
    }

}
