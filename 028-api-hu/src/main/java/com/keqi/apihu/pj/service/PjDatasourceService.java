package com.keqi.apihu.pj.service;

import com.keqi.apihu.pj.domain.PjDatasourceDO;

public interface PjDatasourceService{


    void deleteByDatasourceId(Long datasourceId);

    int create(PjDatasourceDO record);

    int insertSelective(PjDatasourceDO record);

    PjDatasourceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PjDatasourceDO record);

    int updateByPrimaryKey(PjDatasourceDO record);

    void readDataSource(Long datasourceId);
}
