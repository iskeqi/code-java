package com.keqi.springbootmybatistypehandler.typeHandler;

import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * varchar -> java.lang.Double
 */
@Alias("DoubleHandler")
public class DoubleHandler extends BaseTypeHandler<Double> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Double parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toString());
    }

    @Override
    public Double getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String doubleStr = rs.getString(columnName);
        return doubleStr == null ? null : Double.valueOf(doubleStr);
    }

    @Override
    public Double getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String doubleStr = rs.getString(columnIndex);
        return doubleStr == null ? null : Double.valueOf(doubleStr);
    }

    @Override
    public Double getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String doubleStr = cs.getString(columnIndex);
        return doubleStr == null ? null : Double.valueOf(doubleStr);
    }
}
