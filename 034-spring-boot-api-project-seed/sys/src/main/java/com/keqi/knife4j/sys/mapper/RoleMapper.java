package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.knife4j.sys.domain.db.RoleDO;
import com.keqi.knife4j.sys.domain.param.RolePageParam;
import com.keqi.knife4j.sys.domain.vo.RoleVO;

import java.util.List;

public interface RoleMapper extends BaseMapper<RoleDO> {

	List<RoleVO> page(RolePageParam pageParam);

}