package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.knife4j.sys.domain.db.RoleMenuDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuMapper extends BaseMapper<RoleMenuDO> {

	/**
	 * 根据角色ID删除关联关系
	 *
	 * @param roleId roleId
	 * @return r
	 */
	int deleteByRoleId(@Param("roleId") Long roleId);

	/**
	 * 批量新增
	 *
	 * @param list list
	 * @return r
	 */
	int insertList(@Param("list") List<RoleMenuDO> list);


}