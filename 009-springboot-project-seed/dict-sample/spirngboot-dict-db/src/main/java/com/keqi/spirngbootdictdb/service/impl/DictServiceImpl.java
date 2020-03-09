package com.keqi.spirngbootdictdb.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.spirngbootdictdb.domain.Dict;
import com.keqi.spirngbootdictdb.domain.DictVO;
import com.keqi.spirngbootdictdb.mapper.DictMapper;
import com.keqi.spirngbootdictdb.service.DictService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DictServiceImpl implements DictService {

	private final DictMapper dictMapper;

	/**
	 * 查询dictType对应的字典数据
	 *
	 * @param dictType dictType
	 * @return r
	 */
	@Override
	public List<DictVO> listDictByDictType(String dictType) {
		List<Dict> dictList = dictMapper.listDictByDictType(dictType);

		List<DictVO> dictVOList = new ArrayList<>();
		for (Dict dict : dictList) {
			DictVO dictVO = new DictVO();
			BeanUtil.copyProperties(dict, dictVO);
			dictVOList.add(dictVO);
		}
		return dictVOList;
	}
}
