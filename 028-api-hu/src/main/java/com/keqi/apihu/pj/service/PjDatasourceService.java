package com.keqi.apihu.pj.service;

import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.core.common.QueryBaseParam;
import com.keqi.apihu.pj.domain.PjDatasourceDO;

public interface PjDatasourceService {

	void deleteByDatasourceId(Long datasourceId);

	void create(PjDatasourceDO record);

	int insertSelective(PjDatasourceDO record);

	PjDatasourceDO selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PjDatasourceDO record);

	void updateByDatasourceId(PjDatasourceDO record);

	void readDataSource(Long datasourceId);

	PageVO listDatasource(QueryBaseParam queryBaseParam);
}
