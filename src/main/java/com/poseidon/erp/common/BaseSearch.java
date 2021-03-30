package com.poseidon.erp.common;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * @author mario on 2020/9/21.
 */
public interface BaseSearch<T> {

    Wrapper<T> query();

    /**
     * 日期范围
     */
    default String dateRange(String column, String start, String end) {
        if (StrUtil.isNotEmpty(start) && StrUtil.isNotEmpty(end)) {
            return String.format("DATE(%s) between '%s' and '%s'", column, start, end);
        } else if (StrUtil.isEmpty(end)) {
            return String.format("DATE(%s) >= '%s'", column, start);
        } else if (StrUtil.isEmpty(start)) {
            return String.format("DATE(%s) <= '%s'", column, end);
        } else {
            return null;
        }
    }

    /**
     * 日期匹配
     */
    default String dateEqual(String column, String date) {
        return String.format("DATE(%s) = '%s'", column, date);
    }
}
