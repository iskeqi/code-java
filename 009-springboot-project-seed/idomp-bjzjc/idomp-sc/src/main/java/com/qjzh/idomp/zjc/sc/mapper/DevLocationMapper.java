package com.qjzh.idomp.zjc.sc.mapper;

import com.qjzh.idomp.zjc.sc.domain.DevLocationKey;

public interface DevLocationMapper {
    int deleteByPrimaryKey(DevLocationKey key);

    int insert(DevLocationKey record);

    int insertSelective(DevLocationKey record);
}