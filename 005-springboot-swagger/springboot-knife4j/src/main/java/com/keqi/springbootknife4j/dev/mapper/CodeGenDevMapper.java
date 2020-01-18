package com.keqi.springbootknife4j.dev.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.springbootknife4j.dev.domain.CodeGenDO;

public interface CodeGenDevMapper extends BaseMapper<CodeGenDO> {

	CodeGenDO selectByUsername(String username);

}
