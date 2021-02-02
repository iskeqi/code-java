package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.DictItemPageParam;
import com.keqi.knife4j.sys.domain.param.DictItemParam;
import com.keqi.knife4j.sys.domain.vo.DictItemVO;

import java.util.List;

public interface DictItemService {

	void insert(DictItemParam param);

	void updateById(DictItemParam param);

	void deleteById(Long id);

	PageVO<DictItemVO> page(DictItemPageParam param);

	List<DictItemVO> selectByTypeCode(String typeCode);
}
