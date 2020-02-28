package com.keqi.iotplatform.core.dynamic.service;


import com.keqi.iotplatform.core.dynamic.domain.DataSourceBO;

import java.util.Set;

public interface DynamicService {

	/**
	 * 增加HikariCP连接池数据源
	 * @param dataSourceBO dataSourceBO
	 */
	void addHikariCP(DataSourceBO dataSourceBO);

	/**
	 * 移除HikariCP连接池数据源
	 * @param pollName pollName
	 */
	void removeHikariCP(String pollName);

	/**
	 * 获取当前所有数据源的连接池名称
	 * @return r
	 */
	Set<String> listAllDataSource();
}
