package com.keqi.seed.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.seed.sys.domain.db.RoleDO;
import com.keqi.seed.sys.domain.param.RolePageParam;
import com.keqi.seed.sys.domain.vo.RoleVO;

import java.util.List;

public interface RoleMapper extends BaseMapper<RoleDO> {

	List<RoleVO> page(RolePageParam pageParam);

}