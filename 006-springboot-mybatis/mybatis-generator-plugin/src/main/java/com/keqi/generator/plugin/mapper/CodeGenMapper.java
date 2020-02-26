package com.keqi.generator.plugin.mapper;

import com.keqi.generator.plugin.domain.CodeGen;

public interface CodeGenMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CodeGen record);

    int insertSelective(CodeGen record);

    CodeGen selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CodeGen record);

    int updateByPrimaryKey(CodeGen record);
}