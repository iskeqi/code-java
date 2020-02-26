package com.keqi.generator.plugin.mapper;

import com.keqi.generator.plugin.domain.ManualInspection;

public interface ManualInspectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManualInspection record);

    int insertSelective(ManualInspection record);

    ManualInspection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManualInspection record);

    int updateByPrimaryKey(ManualInspection record);
}