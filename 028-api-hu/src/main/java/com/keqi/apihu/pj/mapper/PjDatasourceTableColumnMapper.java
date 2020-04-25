package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.PjDatasourceTableColumnDO;

public interface PjDatasourceTableColumnMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PjDatasourceTableColumnDO record);

    int insertSelective(PjDatasourceTableColumnDO record);

    PjDatasourceTableColumnDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PjDatasourceTableColumnDO record);

    int updateByPrimaryKey(PjDatasourceTableColumnDO record);
}