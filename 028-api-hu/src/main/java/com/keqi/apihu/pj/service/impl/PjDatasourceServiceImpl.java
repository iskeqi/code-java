package com.keqi.apihu.pj.service.impl;

import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.pj.domain.PjDatasourceTableColumnDO;
import com.keqi.apihu.pj.domain.PjDatasourceTableDO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.keqi.apihu.pj.mapper.PjDatasourceMapper;
import com.keqi.apihu.pj.domain.PjDatasourceDO;
import com.keqi.apihu.pj.service.PjDatasourceService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PjDatasourceServiceImpl implements PjDatasourceService {

	private final PjDatasourceMapper pjDatasourceMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return pjDatasourceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PjDatasourceDO record) {
		return pjDatasourceMapper.insert(record);
	}

	@Override
	public int insertSelective(PjDatasourceDO record) {
		return pjDatasourceMapper.insertSelective(record);
	}

	@Override
	public PjDatasourceDO selectByPrimaryKey(Long id) {
		return pjDatasourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PjDatasourceDO record) {
		return pjDatasourceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PjDatasourceDO record) {
		return pjDatasourceMapper.updateByPrimaryKey(record);
	}

    @Override
    public void readDataSource(Long datasourceId) {
        PjDatasourceDO pjDatasourceDO = this.pjDatasourceMapper.selectByPrimaryKey(datasourceId);
        // 读取数据源中的表结构和字段信息
        List<PjDatasourceTableDO> datasourceTableDOList = this.readAllTablesAndFields(pjDatasourceDO);

        // 保存表结构和对应的字段信息

    }

    /**
	 * 获取数据源中的所有表结构以及字段信息
	 *
	 * @param pjDatasourceDO pjDatasourceDO
	 * @return r
	 */
	private List<PjDatasourceTableDO> readAllTablesAndFields(PjDatasourceDO pjDatasourceDO) {
		List<PjDatasourceTableDO> datasourceTableDOList = new ArrayList<>();

		try {
			// 加载驱动&创建连接
			Class.forName(pjDatasourceDO.getDriverClassName());
			Connection connection = DriverManager.
					getConnection(pjDatasourceDO.getUrl(), pjDatasourceDO.getUsername(), pjDatasourceDO.getPassword());
			if (Objects.isNull(connection)) {
				throw new BusinessException("创建连接失败");
			}

			// 获取元数据信息
			DatabaseMetaData metaData = connection.getMetaData();
			ResultSet tables = metaData.getTables(null, "%", "%", new String[]{"TABLE"});
			// 遍历所有表
			while (tables.next()) {
				String tableName = tables.getString("TABLE_NAME");
				String remarks = tables.getString("REMARKS");
				PjDatasourceTableDO PjDatasourceTableDO = new PjDatasourceTableDO(tableName, remarks);
				PjDatasourceTableDO.setDatasourceTableColumnDOList(new ArrayList<>());

				ResultSet columns = metaData.getColumns(null, "%", tableName, "%");
				// 遍历表中的所有字段
				while (columns.next()) {
					String columnName = columns.getString("COLUMN_NAME");
					String columnComment = columns.getString("REMARKS");
					String sqlType = columns.getString("DATA_TYPE");
					PjDatasourceTableColumnDO pjDatasourceTableColumnDO = new PjDatasourceTableColumnDO(columnName, columnComment, sqlType);
					PjDatasourceTableDO.getDatasourceTableColumnDOList().add(pjDatasourceTableColumnDO);
				}
				datasourceTableDOList.add(PjDatasourceTableDO);
			}
		} catch (ClassNotFoundException e) {
			throw new BusinessException("对应驱动不存在");
		} catch (SQLException e) {
			throw new BusinessException("创建连接失败");
		}


		return datasourceTableDOList;
	}
}
