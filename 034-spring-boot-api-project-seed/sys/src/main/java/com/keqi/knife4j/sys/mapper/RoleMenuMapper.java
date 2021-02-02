package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.knife4j.sys.domain.db.RoleMenuDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuMapper extends BaseMapper<RoleMenuDO> {

	int insertList(@Param("list") List<RoleMenuDO> list);

	int deleteByRoleId(Long roleId);
}