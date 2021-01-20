package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.knife4j.sys.domain.db.ParamConfigDO;
import com.keqi.knife4j.sys.domain.param.ParamConfigPageParam;
import com.keqi.knife4j.sys.domain.vo.ParamConfigVO;

import java.util.List;

public interface ParamConfigMapper extends BaseMapper<ParamConfigDO> {

	/**
	 * 分页查询参数配置列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	List<ParamConfigVO> page(ParamConfigPageParam pageParam);

}