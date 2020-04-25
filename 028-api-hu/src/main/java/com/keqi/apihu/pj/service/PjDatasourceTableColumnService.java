package com.keqi.apihu.pj.service;

import com.keqi.apihu.pj.domain.PjDatasourceTableColumnDO;
public interface PjDatasourceTableColumnService{


    int deleteByPrimaryKey(Long id);

    int insert(PjDatasourceTableColumnDO record);

    int insertSelective(PjDatasourceTableColumnDO record);

    PjDatasourceTableColumnDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PjDatasourceTableColumnDO record);

    int updateByPrimaryKey(PjDatasourceTableColumnDO record);

}
