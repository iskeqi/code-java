package com.keqi.apihu.pj.service.impl;

import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.core.common.QueryBaseParam;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.pj.domain.PjDatasourceDO;
import com.keqi.apihu.pj.domain.PjDatasourceTableColumnDO;
import com.keqi.apihu.pj.domain.PjDatasourceTableDO;
import com.keqi.apihu.pj.mapper.PjDatasourceMapper;
import com.keqi.apihu.pj.service.PjDatasourceService;
import com.keqi.apihu.pj.service.PjDatasourceTableColumnService;
import com.keqi.apihu.pj.service.PjDatasourceTableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PjDatasourceServiceImpl implements PjDatasourceService {

	private final PjDatasourceMapper pjDatasourceMapper;
	private final PjDatasourceTableService pjDatasourceTableService;
	private final PjDatasourceTableColumnService pjDatasourceTableColumnService;

	@Override
	@Transactional
	public void deleteByDatasourceId(Long datasourceId) {
		this.pjDatasourceMapper.deleteByPrimaryKey(datasourceId);
		this.pjDatasourceTableService.deleteByDatasourceId(datasourceId);
		this.pjDatasourceTableColumnService.deleteByDatasourceId(datasourceId);
	}

	@Override
	@Transactional
	public void create(PjDatasourceDO record) {
		pjDatasourceMapper.insert(record);
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
	@Transactional
	public void updateByDatasourceId(PjDatasourceDO record) {
		pjDatasourceMapper.updateByDatasourceId(record);
	}

	@Override
	@Transactional
	public void readDataSource(Long datasourceId) {
		PjDatasourceDO pjDatasourceDO = this.pjDatasourceMapper.selectByPrimaryKey(datasourceId);
		// 读取数据源中的表结构和字段信息
		List<PjDatasourceTableDO> datasourceTableDOList = this.readAllTablesAndFields(pjDatasourceDO);

		// 批量保存所有表结构
		for (PjDatasourceTableDO pjDatasourceTableDO : datasourceTableDOList) {
			pjDatasourceTableDO.setDatasourceId(datasourceId);
		}
		this.pjDatasourceTableService.insertList(datasourceTableDOList);

		// 批量保存所有表中的所有列
		List<PjDatasourceTableColumnDO> pjDatasourceTableColumnDOList = new ArrayList<>();
		for (PjDatasourceTableDO pjDatasourceTableDO : datasourceTableDOList) {
			for (PjDatasourceTableColumnDO pjDatasourceTableColumnDO : pjDatasourceTableDO.getDatasourceTableColumnDOList()) {
				pjDatasourceTableColumnDO.setDatasourceId(datasourceId);
				pjDatasourceTableColumnDO.setDatasourceTableId(pjDatasourceTableDO.getId());
				pjDatasourceTableColumnDOList.add(pjDatasourceTableColumnDO);
			}
		}
		this.pjDatasourceTableColumnService.insertList(pjDatasourceTableColumnDOList);
	}

	@Override
	public PageVO listDatasource(QueryBaseParam queryBaseParam) {
		long total = this.pjDatasourceMapper.count(queryBaseParam);
		List<PjDatasourceDO> pjDatasourceDOList = null;
		if (total > 0) {
			pjDatasourceDOList = this.pjDatasourceMapper.list(queryBaseParam);
		}

		return new PageVO(total, pjDatasourceDOList);
	}

	//================================私有方法================================//

	/**
	 * 获取数据源中的所有表结构以及字段信息
	 *
	 * @param pjDatasourceDO pjDatasourceDO
	 * @return r
	 */
	private List<PjDatasourceTableDO> readAllTablesAndFields(PjDatasourceDO pjDatasourceDO) {
		List<PjDatasourceTableDO> datasourceTableDOList = new ArrayList<>();
		Connection connection = null;
		try {
			// 加载驱动&创建连接
			Class.forName(pjDatasourceDO.getDriverClassName());
			connection = DriverManager.
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
				PjDatasourceTableDO pjDatasourceTableDO = new PjDatasourceTableDO(tableName, remarks);
				pjDatasourceTableDO.setDatasourceTableColumnDOList(new ArrayList<>());

				ResultSet columns = metaData.getColumns(null, "%", tableName, "%");
				// 遍历表中的所有字段
				while (columns.next()) {
					String columnName = columns.getString("COLUMN_NAME");
					String columnComment = columns.getString("REMARKS");
					String sqlType = columns.getString("DATA_TYPE");
					PjDatasourceTableColumnDO pjDatasourceTableColumnDO = new PjDatasourceTableColumnDO(columnName, columnComment, sqlType);
					pjDatasourceTableDO.getDatasourceTableColumnDOList().add(pjDatasourceTableColumnDO);
				}
				datasourceTableDOList.add(pjDatasourceTableDO);
			}
		} catch (ClassNotFoundException e) {
			throw new BusinessException("对应驱动不存在");
		} catch (SQLException e) {
			throw new BusinessException("创建连接失败");
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return datasourceTableDOList;
	}
}
