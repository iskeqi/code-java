package com.keqi.knife4j.core.typeHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.keqi.knife4j.core.util.JsonUtil;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * JSON 类型转换器（支持 array 类型的）
 */
@Alias("JsonListMapHandler")
public class JsonListMapHandler extends BaseTypeHandler<List<Map<String, Object>>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Map<String, Object>> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, JsonUtil.writeValueAsString(parameter));
    }

    @Override
    public List<Map<String, Object>> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String jsonStr = rs.getString(columnName);

        return jsonStr == null ? null : JsonUtil.readValue(jsonStr, new TypeReference<List<Map<String, Object>>>() {
        });
    }

    @Override
    public List<Map<String, Object>> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String jsonStr = rs.getString(columnIndex);
        return jsonStr == null ? null : JsonUtil.readValue(jsonStr, new TypeReference<List<Map<String, Object>>>() {
        });
    }

    @Override
    public List<Map<String, Object>> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String jsonStr = cs.getString(columnIndex);
        return jsonStr == null ? null : JsonUtil.readValue(jsonStr, new TypeReference<List<Map<String, Object>>>() {
        });
    }
}
