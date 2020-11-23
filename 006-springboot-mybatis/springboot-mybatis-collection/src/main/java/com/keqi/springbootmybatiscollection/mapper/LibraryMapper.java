package com.keqi.springbootmybatiscollection.mapper;

import com.keqi.springbootmybatiscollection.domain.Library;

public interface LibraryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Library record);

    int insertSelective(Library record);

    Library selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Library record);

    int updateByPrimaryKey(Library record);
}