package com.keqi.apihu.pj.service;

import com.keqi.apihu.pj.domain.PjDatasourceTableDO;
public interface PjDatasourceTableService{


    int deleteByPrimaryKey(Long id);

    int insert(PjDatasourceTableDO record);

    int insertSelective(PjDatasourceTableDO record);

    PjDatasourceTableDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PjDatasourceTableDO record);

    int updateByPrimaryKey(PjDatasourceTableDO record);

}
