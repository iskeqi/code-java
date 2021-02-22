package com.keqi.seed.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.seed.sys.domain.db.DictItemDO;
import com.keqi.seed.sys.domain.param.DictItemPageParam;
import com.keqi.seed.sys.domain.vo.DictItemVO;

import java.util.List;

public interface DictItemMapper extends BaseMapper<DictItemDO> {

	List<String> selectTypeCodeList();

	List<DictItemVO> selectByTypeCode(String typeCode);

	List<DictItemVO> page(DictItemPageParam pageParam);

	List<DictItemVO> selectAll();
}