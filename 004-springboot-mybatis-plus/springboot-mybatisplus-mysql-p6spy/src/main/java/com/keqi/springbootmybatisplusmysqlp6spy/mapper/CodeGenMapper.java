package com.keqi.springbootmybatisplusmysqlp6spy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.springbootmybatisplusmysqlp6spy.domain.CodeGenDO;

public interface CodeGenMapper extends BaseMapper<CodeGenDO> {

	CodeGenDO selectByUsername(String username);

}
