package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.SysRoleDTO;
import com.poseidon.erp.bean.entity.SysRole;
import com.poseidon.erp.bean.search.SysRoleSearch;
import com.poseidon.erp.service.SysRoleService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色 控制器
 *
 * @author mario on 2020-09-30
 */
@Api(value = "角色管理", tags = "角色管理")
@RestController
@RequestMapping("sys_roles")
public class SysRoleController {

    private final SysRoleService service;

    public SysRoleController(SysRoleService service){
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<SysRole>> page(Page<SysRole> page, SysRoleSearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<SysRole>> list(SysRoleSearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "用户角色列表")
    @GetMapping("list/{userId}")
    public R<List<SysRole>> listByUser(@PathVariable Long userId) {
        return R.ok(service.findByUserId(userId));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<SysRole> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated SysRoleDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated SysRoleDTO dto) {
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
