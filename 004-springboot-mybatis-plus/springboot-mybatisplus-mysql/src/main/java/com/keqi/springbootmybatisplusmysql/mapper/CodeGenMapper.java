package com.keqi.springbootmybatisplusmysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.springbootmybatisplusmysql.domain.CodeGenDO;

public interface CodeGenMapper extends BaseMapper<CodeGenDO> {

	CodeGenDO selectByUsername(String username);

}
