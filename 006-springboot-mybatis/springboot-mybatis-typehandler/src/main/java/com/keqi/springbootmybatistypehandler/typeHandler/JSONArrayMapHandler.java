package com.keqi.springbootmybatistypehandler.typeHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keqi.springbootmybatistypehandler.util.JsonUtil;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Alias("JSONArrayMapHandler")
public class JSONArrayMapHandler extends BaseTypeHandler<List<Map<String, Object>>> {

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Map<String, Object>> parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setString(i, objectMapper.writeValueAsString(parameter));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Map<String, Object>> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String jsonStr = rs.getString(columnName);
        List<Map<String, Object>> obj = null;
        obj = jsonStr == null ? null : JsonUtil.readValue(jsonStr, new TypeReference<List<Map<String, Object>>>() {});
        return obj;
    }

    @Override
    public List<Map<String, Object>> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String jsonStr = rs.getString(columnIndex);
        List<Map<String, Object>> obj = null;
        obj = jsonStr == null ? null : JsonUtil.readValue(jsonStr, new TypeReference<List<Map<String, Object>>>() {});
        return obj;
    }

    @Override
    public List<Map<String, Object>> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String jsonStr = cs.getString(columnIndex);
        List<Map<String, Object>> obj = null;
        obj = jsonStr == null ? null : JsonUtil.readValue(jsonStr, new TypeReference<List<Map<String, Object>>>() {});
        return obj;
    }
}
