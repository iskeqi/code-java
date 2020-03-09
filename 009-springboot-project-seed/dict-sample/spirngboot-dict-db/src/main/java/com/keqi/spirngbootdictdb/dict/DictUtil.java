package com.keqi.spirngbootdictdb.dict;

import com.keqi.spirngbootdictdb.domain.Dict;
import com.keqi.spirngbootdictdb.mapper.DictMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典工具类(程序启动时就把字典表中的数据全部读到程序中)
 */
@Component
public class DictUtil{

	private static Map<String, Map<String, String>> dictMap = new HashMap<>();

	private final DictMapper dictMapper;

	public DictUtil(DictMapper dictMapper) {
		this.dictMapper = dictMapper;
	}

	/**
	 * 查询字典表中的所有数据，并组装到dictMap对象中去
	 */
	@PostConstruct
	public void init() {
		List<Dict> dictList = this.dictMapper.listAll();
		for (Dict dict : dictList) {
			String dictType = dict.getDictType();
			String valueCode = dict.getValueCode();
			String valueName = dict.getValueName();
			if (!dictMap.containsKey(dictType)) {
				dictMap.put(dictType, new HashMap<>());
				dictMap.get(dictType).put(valueCode, valueName);
			}
			if (dictMap.containsKey(dictType) && !dictMap.get(dictType).containsKey(valueCode)) {
				dictMap.get(dictType).put(valueCode, valueName);
			}
		}
	}

	/**
	 * 根据dictType和valueCode获取ValueName的值
	 * @param dictType dictType
	 * @param valueCode valueCode
	 * @return r
	 */
	public static String getVlueName(String dictType, String valueCode) {
		return dictMap.get(dictType) == null ? null : dictMap.get(dictType).get(valueCode);
	}
}
