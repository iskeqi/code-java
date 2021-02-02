package com.keqi.seed.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.seed.sys.domain.db.ParamConfigDO;
import com.keqi.seed.sys.domain.param.ParamConfigPageParam;
import com.keqi.seed.sys.domain.vo.ParamConfigVO;

import java.util.List;

public interface ParamConfigMapper extends BaseMapper<ParamConfigDO> {

	List<ParamConfigVO> page(ParamConfigPageParam pageParam);

}