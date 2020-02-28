package com.keqi.iotplatform.core.dynamic.service.impl;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.HikariDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.keqi.iotplatform.core.dynamic.domain.DataSourceBO;
import com.keqi.iotplatform.core.dynamic.service.DynamicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Set;

@Service
@AllArgsConstructor
public class DynamicServiceImpl implements DynamicService {

	private final DataSource dataSource;
	private final HikariDataSourceCreator hikariDataSourceCreator;

	/**
	 * 增加HikariCP连接池数据源
	 *
	 * @param dataSourceBO dataSourceBO
	 */
	@Override
	public void addHikariCP(DataSourceBO dataSourceBO) {
		DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;

		String pollName = dataSourceBO.getPollName();
		// 存在数据源则直接结束，不存在才新增
		Map<String, DataSource> currentDataSources = ds.getCurrentDataSources();
		if (currentDataSources.containsKey(pollName)) {
			return;
		}

		// 初始化DataSourceProperty对象
		DataSourceProperty dataSourceProperty = new DataSourceProperty();
		BeanUtils.copyProperties(dataSourceBO, dataSourceProperty);

		// 创建HikariCP连接池数据源对象
		DataSource dataSource = hikariDataSourceCreator.createDataSource(dataSourceProperty);
		// 将新建的数据源添加DateSource中
		ds.addDataSource(dataSourceBO.getPollName(), dataSource);
	}

	/**
	 * 移除HikariCP连接池数据源
	 *
	 * @param pollName pollName
	 */
	@Override
	public void removeHikariCP(String pollName) {
		DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
		ds.removeDataSource(pollName);
	}

	/**
	 * 获取当前所有数据源的连接池名称
	 *
	 * @return r
	 */
	@Override
	public Set<String> listAllDataSource() {
		DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
		return ds.getCurrentDataSources().keySet();
	}
}
