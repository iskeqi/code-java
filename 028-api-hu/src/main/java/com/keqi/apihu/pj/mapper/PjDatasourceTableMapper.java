package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.PjDatasourceTableDO;

public interface PjDatasourceTableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PjDatasourceTableDO record);

    int insertSelective(PjDatasourceTableDO record);

    PjDatasourceTableDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PjDatasourceTableDO record);

    int updateByPrimaryKey(PjDatasourceTableDO record);
}