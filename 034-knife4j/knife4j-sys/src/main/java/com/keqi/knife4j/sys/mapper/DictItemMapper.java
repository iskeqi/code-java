package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.knife4j.sys.domain.db.DictItemDO;
import com.keqi.knife4j.sys.domain.param.DictItemPageParam;
import com.keqi.knife4j.sys.domain.vo.DictItemVO;

import java.util.List;

public interface DictItemMapper extends BaseMapper<DictItemDO> {

	List<String> selectTypeCodeList();

	List<DictItemVO> selectByTypeCode(String typeCode);

	List<DictItemVO> page(DictItemPageParam pageParam);

	List<DictItemVO> selectAll();
}