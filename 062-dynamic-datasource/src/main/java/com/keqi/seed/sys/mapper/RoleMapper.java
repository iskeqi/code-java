package com.keqi.seed.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.keqi.seed.sys.domain.db.RoleDO;
import com.keqi.seed.sys.domain.param.RolePageParam;

public interface RoleMapper extends BaseMapper<RoleDO> {
    IPage<RoleDO> page(RolePageParam param);
}