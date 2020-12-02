package com.keqi.bestpracticeone.core.typeHandler;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 不确定 {}还是[] 为根节点的 JSON 对象
 *
 * @author keqi
 */
@Alias("JSONHandler")
public class JSONHandler extends BaseTypeHandler<JSON> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, JSON parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, JSON.toJSONString(parameter));
    }

    @Override
    public JSON getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String jsonStr = rs.getString(columnName);
        return jsonStr == null ? null : JSON.parseObject(jsonStr);
    }

    @Override
    public JSON getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String jsonStr = rs.getString(columnIndex);
        return jsonStr == null ? null : JSON.parseObject(jsonStr);
    }

    @Override
    public JSON getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String jsonStr = cs.getString(columnIndex);
        return jsonStr == null ? null : JSON.parseObject(jsonStr);
    }
}
