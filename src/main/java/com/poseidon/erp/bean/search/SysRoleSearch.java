package com.poseidon.erp.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.SysRole;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 搜索
 *
 * @author mario on 2020-09-30
 */
@Getter
@Setter
public class SysRoleSearch implements BaseSearch<SysRole> {

    @ApiParam(value = "角色名", name = "name")
    private String name;
    @ApiParam(value = "角色编码", name = "code")
    private String code;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;

    @Override
    public Wrapper<SysRole> query() {
        return Wrappers
                .<SysRole>lambdaQuery()
                .like(StrUtil.isNotBlank(name), SysRole::getName, name)
                .like(StrUtil.isNotBlank(code), SysRole::getCode, code)
                .apply(StrUtil.isAllNotEmpty(startDate, endDate), dateRange("create_time", startDate, endDate))
                .orderByDesc(SysRole::getId)
                ;
    }
}
