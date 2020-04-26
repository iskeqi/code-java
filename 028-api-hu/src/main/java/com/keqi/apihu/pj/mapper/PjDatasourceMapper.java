package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.core.common.QueryBaseParam;
import com.keqi.apihu.pj.domain.PjDatasourceDO;

import java.util.List;

public interface PjDatasourceMapper {
	int deleteByPrimaryKey(Long id);

	int insert(PjDatasourceDO record);

	int insertSelective(PjDatasourceDO record);

	PjDatasourceDO selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PjDatasourceDO record);

	int updateByDatasourceId(PjDatasourceDO record);

	long count(QueryBaseParam queryBaseParam);

	List<PjDatasourceDO> list(QueryBaseParam queryBaseParam);
}