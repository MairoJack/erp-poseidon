package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.SysUserDTO;
import com.poseidon.erp.bean.entity.SysUser;
import com.poseidon.erp.bean.search.SysUserSearch;
import com.poseidon.erp.bean.vo.SysUserVO;
import com.poseidon.erp.common.Create;
import com.poseidon.erp.common.Update;
import com.poseidon.erp.service.SysUserService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mario on 2020/9/21.
 */
@Api(value = "用户管理", tags = "用户管理")
@RestController
@RequestMapping("sys_users")
public class SysUserController {

    private final SysUserService service;
    private final ConsumerTokenServices consumerTokenServices;

    public SysUserController(SysUserService service, ConsumerTokenServices consumerTokenServices) {
        this.service = service;
        this.consumerTokenServices = consumerTokenServices;
    }

    @DeleteMapping("logout")
    public R<?> logout(String access_token) {
        if (consumerTokenServices.revokeToken(access_token)) {
            return R.ok();
        }
        return R.fail("注销失败");
    }

    @ApiOperation("获取用户信息")
    @GetMapping("info")
    public R<SysUserVO> info() {
        return R.ok(service.userInfo());
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<SysUser>> page(Page<SysUser> page, SysUserSearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public R<List<SysUser>> list(SysUserSearch search) {
        return R.ok(service.list(search));
    }

    @ApiOperation(value = "详情")
    @GetMapping("{id}")
    public R<SysUser> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public R<?> create(@RequestBody @Validated(Create.class) SysUserDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated(Update.class) SysUserDTO dto) {
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
