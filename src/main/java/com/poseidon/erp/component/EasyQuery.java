package com.poseidon.erp.component;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/**
 * 封装LambdaQueryWrapper 更简便，暂未完全
 *
 * @author mario on 2020/11/5.
 */
public class EasyQuery<T> {

    private final LambdaQueryWrapper<T> wrapper;

    public EasyQuery() {
        wrapper = Wrappers.lambdaQuery();
    }

    public LambdaQueryWrapper<T> startWith(SFunction<T, ?> column, String val) {
        return wrapper.likeLeft(StrUtil.isNotBlank(val), column, val);
    }

    public LambdaQueryWrapper<T> like(SFunction<T, ?> column, String val) {
        return wrapper.like(StrUtil.isNotBlank(val), column, val);
    }
}
