package com.keqi.spirngbootdictdb.service;

import com.keqi.spirngbootdictdb.common.BaseService;
import com.keqi.spirngbootdictdb.domain.DictVO;

import java.util.List;

public interface DictService extends BaseService {

	/**
	 * 查询dictType对应的字典数据
	 * @param dictType dictType
	 * @return r
	 */
	List<DictVO> listDictByDictType(String dictType);
}
