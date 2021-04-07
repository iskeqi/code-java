package com.keqi.seed.core.typeHandler;

import com.keqi.seed.core.pojo.BaseEnum;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * BaseEnum 类型转换器
 *
 * @author keqi
 */
@Alias("BaseEnumTypeHandler")
public class BaseEnumTypeHandler<E extends BaseEnum> extends BaseTypeHandler<E> {

    private final Map<Integer, E> enumMap = new HashMap<>();

    public BaseEnumTypeHandler(Class<E> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");

        E[] enums = type.getEnumConstants();
        if (enums == null)
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        for (E e : enums) {
            enumMap.put(e.getCode(), e);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return get(rs.getInt(columnName));
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return get(rs.getInt(columnIndex));
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return get(cs.getInt(columnIndex));
    }

    private E get(Integer v) {
        if (v == null) {
            return null;
        }

        return this.enumMap.get(v);
    }

}
