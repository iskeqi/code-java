package com.keqi.springbootmpdynamic.service;

import com.keqi.springbootmpdynamic.domain.DataSourceBO;

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
}
