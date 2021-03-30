package com.poseidon.erp.component;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mario on 2020/5/19
 */
public class StringArrayTypeHandler extends BaseTypeHandler<List<String>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, CollUtil.join(parameter, ","));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        if (rs.wasNull())
            return null;
        return getResult(rs.getString(columnName));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, int i) throws SQLException {
        if (rs.wasNull())
            return null;
        return getResult(rs.getString(i));
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int i) throws SQLException {
        if (cs.wasNull())
            return null;
        return getResult(cs.getString(i));
    }

    private static List<String> getResult(String str) {
        if (StrUtil.isEmpty(str)) {
            return Lists.newArrayList();
        }
        return Arrays.stream(str.split(",")).collect(Collectors.toList());
    }
}
