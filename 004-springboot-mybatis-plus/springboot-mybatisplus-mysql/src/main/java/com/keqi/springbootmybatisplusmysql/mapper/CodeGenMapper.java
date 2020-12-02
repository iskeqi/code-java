package com.keqi.springbootmybatisplusmysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.springbootmybatisplusmysql.domain.CodeGenDO;
import com.keqi.springbootmybatisplusmysql.domain.PageCodeGenParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.compiler.CodeGen;

import java.util.List;
import java.util.Map;

public interface CodeGenMapper extends BaseMapper<CodeGenDO> {

	CodeGenDO selectByUsername(String username);

	IPage<CodeGenDO> page1(PageCodeGenParam param);

	List<CodeGenDO> page2(PageCodeGenParam param);

	List<CodeGenDO> page3(@Param("page") IPage<CodeGenDO> page,
						  @Param("pageCodeGenParam") PageCodeGenParam pageCodeGenParam);

	IPage<CodeGenDO> page4(@Param("page") IPage<CodeGen> page, @Param("pageCodeGenParam") PageCodeGenParam pageCodeGenParam);
}
