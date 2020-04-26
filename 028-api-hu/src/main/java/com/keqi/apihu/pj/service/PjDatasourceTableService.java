package com.keqi.apihu.pj.service;

import com.keqi.apihu.pj.domain.PjDatasourceTableDO;

import java.util.List;

public interface PjDatasourceTableService {


	int deleteByPrimaryKey(Long id);

	int insert(PjDatasourceTableDO record);

	int insertSelective(PjDatasourceTableDO record);

	PjDatasourceTableDO selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PjDatasourceTableDO record);

	int updateByPrimaryKey(PjDatasourceTableDO record);

	void deleteByDatasourceId(Long datasourceId);

	void insertList(List<PjDatasourceTableDO> datasourceTableDOList);
}
