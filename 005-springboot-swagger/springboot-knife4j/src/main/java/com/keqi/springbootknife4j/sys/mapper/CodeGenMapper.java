package com.keqi.springbootknife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.springbootknife4j.sys.domain.CodeGenDO;

public interface CodeGenMapper extends BaseMapper<CodeGenDO> {

	CodeGenDO selectByUsername(String username);

}
