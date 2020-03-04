package com.qjzh.idomp.zjc.sc.mapper;

import com.qjzh.idomp.zjc.sc.domain.DictData;

import java.util.List;

public interface DictDataMapper {

	/**
	 * 查询指定dictType对应的字典数据列表
	 *
	 * @param dictType dictType
	 * @return r
	 */
	List<DictData> listByDictType(String dictType);

	/**
	 * 删除dictType对应的字典数据列表
	 *
	 * @param dictType dictType
	 */
	void deleteByDictType(String dictType);


	/**
	 * 增加记录
	 *
	 * @param record record
	 * @return r
	 */
	int insert(DictData record);

	/**
	 * 根据主键进行修改
	 * @param record record
	 * @return r
	 */
	int updateByPrimaryKey(DictData record);
}