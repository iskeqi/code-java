package com.keqi.knife4j.sys.util;

import com.keqi.knife4j.sys.domain.vo.DictItemVO;
import com.keqi.knife4j.sys.mapper.DictItemMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 程序启动后读取 sys_dict_item 表中的所数据，并存储在内存中
 *
 * @author keqi
 */
@Component
public class DictUtil implements CommandLineRunner {

	private static Map<String, List<DictItemVO>> dictTypeMap;
	private static Map<String, DictItemVO> dictItemMap;

	private final DictItemMapper dictItemMapper;

	public DictUtil(DictItemMapper dictItemMapper) {
		this.dictItemMapper = dictItemMapper;
	}

	@Override
	public void run(String... args) {
		dictTypeMap = new HashMap<>();
		dictItemMap = new HashMap<>();

		List<DictItemVO> dictItemVOS = this.dictItemMapper.listAll();

		for (DictItemVO t : dictItemVOS) {
			String typeCode = t.getTypeCode();
			String itemCode = t.getItemCode();

			List<DictItemVO> list = dictTypeMap.get(typeCode);
			if (list == null || list.size() == 0) {
				list = new ArrayList<>();
				dictTypeMap.put(typeCode, list);
			} else {
				list.add(t);
			}

			dictItemMap.put(itemCode, t);
		}
	}

	/**
	 * 根据 typeCode 获取对应的 DictItemVO 列表
	 *
	 * @param typeCode typeCode
	 * @return r
	 */
	public static List<DictItemVO> listDictItem(String typeCode) {
		return dictTypeMap.get(typeCode);
	}


	/**
	 * 根据 typeCode 和 itemCode 获取对应的 DictItemVO
	 *
	 * @param typeCode typeCode
	 * @param itemCode itemCode
	 * @return r
	 */
	public static DictItemVO getDictItem(String typeCode, String itemCode) {
		List<DictItemVO> dictItemVOS = dictTypeMap.get(typeCode);
		for (DictItemVO t : dictItemVOS) {
			if (Objects.equals(itemCode, t.getItemCode())) {
				return t;
			}
		}
		return null;
	}

	/**
	 * 根据 typeCode 和 itemCode 获取对应的 ItemName
	 *
	 * @param typeCode typeCode
	 * @param itemCode itemCode
	 * @return r
	 */
	public static String getItemName(String typeCode, String itemCode) {
		DictItemVO dictItemVO = getDictItem(typeCode, itemCode);
		return dictItemVO == null ? null : dictItemVO.getItemName();
	}

	/**
	 * 根据 itemCode 获取对应的 ItemName(因为itemCode添加了唯一索引，所以完全可以这么干)
	 *
	 * @param itemCode itemCode
	 * @return r
	 */
	public static String getItemName(String itemCode) {
		DictItemVO dictItemVO = dictItemMap.get(itemCode);
		return dictItemVO == null ? null : dictItemVO.getItemName();
	}

	/**
	 * 查询系统内所有字典数据
	 *
	 * @return r
	 */
	public static Map<String, List<DictItemVO>> getDictTypeMap() {
		return dictTypeMap;
	}
}
