package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.DeliveryDetailDTO;
import com.poseidon.erp.bean.entity.DeliveryDetail;
import com.poseidon.erp.bean.search.DeliveryDetailSearch;
import com.poseidon.erp.service.DeliveryDetailService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 货件明细控制器
 *
 * @author mario on 2020-12-04
 */
@Api(value = "货件明细管理", tags = "货件明细管理")
@RestController
@RequestMapping("delivery_details")
public class DeliveryDetailController {

    private final DeliveryDetailService service;

    public DeliveryDetailController(DeliveryDetailService service){
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<DeliveryDetail>> page(Page<DeliveryDetail> page, DeliveryDetailSearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<DeliveryDetail>> list(DeliveryDetailSearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<DeliveryDetail> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated DeliveryDetailDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated DeliveryDetailDTO dto) {
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
