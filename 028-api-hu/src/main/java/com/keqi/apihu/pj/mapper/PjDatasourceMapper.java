package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.PjDatasourceDO;

public interface PjDatasourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PjDatasourceDO record);

    int insertSelective(PjDatasourceDO record);

    PjDatasourceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PjDatasourceDO record);

    int updateByPrimaryKey(PjDatasourceDO record);
}