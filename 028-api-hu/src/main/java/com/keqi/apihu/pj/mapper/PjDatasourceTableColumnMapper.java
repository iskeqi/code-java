package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.PjDatasourceTableColumnDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PjDatasourceTableColumnMapper {
	int deleteByPrimaryKey(Long id);

	int insert(PjDatasourceTableColumnDO record);

	void insertList(@Param("pjDatasourceTableColumnDOList") List<PjDatasourceTableColumnDO> pjDatasourceTableColumnDOList);

	int insertSelective(PjDatasourceTableColumnDO record);

	PjDatasourceTableColumnDO selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PjDatasourceTableColumnDO record);

	int updateByPrimaryKey(PjDatasourceTableColumnDO record);

	void deleteByDatasourceId(Long datasourceId);
}