package com.poseidon.erp.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.SysUser;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 搜索
 *
 * @author mario on 2020-10-26
 */
@Getter
@Setter
public class SysUserSearch implements BaseSearch<SysUser> {

    @ApiParam(value = "姓名", name = "name")
    private String name;
    @ApiParam(value = "账号", name = "username")
    private String username;
    @ApiParam(value = "姓名", name = "realname")
    private String realname;
    @ApiParam(value = "开始日期", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期", name = "endDate")
    private String endDate;

    @ApiParam(value = "关键词", name = "keyword")
    private String keyword;
    @Override
    public Wrapper<SysUser> query() {
        return Wrappers
                .<SysUser>lambdaQuery()
                .like(StrUtil.isNotBlank(keyword), SysUser::getRealname, keyword)
                .like(StrUtil.isNotBlank(name), SysUser::getRealname, name)
                .like(StrUtil.isNotBlank(username), SysUser::getUsername, username)
                .like(StrUtil.isNotBlank(realname), SysUser::getRealname, realname)
                .apply(StrUtil.isAllNotEmpty(startDate,endDate),dateRange("entry_date", startDate, endDate))
                .orderByDesc(SysUser::getId)
                ;
    }
}
