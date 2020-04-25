package com.keqi.apihu.pj.service;

import com.keqi.apihu.pj.domain.PjDatasourceDO;
import com.keqi.apihu.pj.domain.PjDatasourceTableDO;

import java.util.List;

public interface PjDatasourceService{


    int deleteByPrimaryKey(Long id);

    int insert(PjDatasourceDO record);

    int insertSelective(PjDatasourceDO record);

    PjDatasourceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PjDatasourceDO record);

    int updateByPrimaryKey(PjDatasourceDO record);

    void readDataSource(Long datasourceId);
}
