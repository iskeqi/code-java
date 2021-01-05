package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.keqi.knife4j.sys.domain.db.MenuDO;
import com.keqi.knife4j.sys.domain.param.MenuPageParam;
import com.keqi.knife4j.sys.domain.vo.MenuVO;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper extends BaseMapper<MenuDO> {

	/**
	 * 分页查询菜单列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	IPage<MenuVO> page(@Param("page") IPage<MenuVO> page, @Param("pageParam") MenuPageParam pageParam);

}