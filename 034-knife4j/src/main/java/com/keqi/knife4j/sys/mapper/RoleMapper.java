package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.keqi.knife4j.sys.domain.db.RoleDO;
import com.keqi.knife4j.sys.domain.param.RolePageParam;
import com.keqi.knife4j.sys.domain.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper extends BaseMapper<RoleDO> {

	/**
	 * 分页查询角色列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	IPage<RoleVO> page(@Param("page") IPage<RoleVO> page, @Param("pageParam") RolePageParam pageParam);

}