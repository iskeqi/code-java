package com.keqi.apihu.pj.service;

public interface PjDatasourceTableColumnService{


    int deleteByPrimaryKey(Long id);

    int insert(PjDatasourceTableColumnDO record);

    int insertSelective(PjDatasourceTableColumnDO record);

    PjDatasourceTableColumnDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PjDatasourceTableColumnDO record);

    int updateByPrimaryKey(PjDatasourceTableColumnDO record);

}
