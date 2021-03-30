package com.poseidon.erp.controller;

import com.poseidon.erp.bean.form.AssignPermissionForm;
import com.poseidon.erp.bean.vo.TreeNode;
import com.poseidon.erp.service.SysPermissionService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单控制器
 *
 * @author mario on 2020-10-14
 */
@Api(value = "权限管理", tags = "权限管理")
@RestController
@RequestMapping("sys_permissions")
public class SysPermissionController {

    private final SysPermissionService service;

    public SysPermissionController(SysPermissionService service) {
        this.service = service;
    }

    @ApiOperation(value = "查询角色权限")
    @GetMapping("list/{roleId}")
    public R<List<Long>> getRoleList(@PathVariable Long roleId) {
        return R.ok(service.getRoleList(roleId));
    }

    @ApiOperation(value = "查询权限树")
    @GetMapping("tree")
    public R<List<TreeNode>> getTree() {
        return R.ok(service.getTree());
    }

    @ApiOperation(value = "分配权限")
    @PutMapping("assign")
    public R<List<TreeNode>> assign(@RequestBody @Validated AssignPermissionForm form) {
        service.assign(form);
        return R.ok();
    }

}
