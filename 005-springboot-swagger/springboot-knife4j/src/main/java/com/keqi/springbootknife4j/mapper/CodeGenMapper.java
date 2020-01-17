package com.keqi.springbootknife4j.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.springbootknife4j.domain.CodeGenDO;

public interface CodeGenMapper extends BaseMapper<CodeGenDO> {

	CodeGenDO selectByUsername(String username);

}
