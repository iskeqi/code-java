package com.keqi.springbootmybatisbase.sys.mapper;

import com.keqi.springbootmybatisbase.core.BaseMapper;
import com.keqi.springbootmybatisbase.sys.domain.db.MenuDO;
import com.keqi.springbootmybatisbase.sys.domain.param.MenuPageParam;
import com.keqi.springbootmybatisbase.sys.domain.vo.MenuVO;

public interface MenuMapper extends BaseMapper<MenuDO, MenuVO, MenuPageParam> {

}