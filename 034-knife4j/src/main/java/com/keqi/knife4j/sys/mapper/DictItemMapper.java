package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.knife4j.sys.domain.db.DictItemDO;
import com.keqi.knife4j.sys.domain.param.DictItemPageParam;
import com.keqi.knife4j.sys.domain.vo.DictItemVO;

import java.util.List;

public interface DictItemMapper extends BaseMapper<DictItemDO> {

	/**
	 * 查询所有 TypeCode
	 *
	 * @return r
	 */
	List<String> listAllTypeCode();

	/**
	 * 根据 typeCode 查询对应的所有字典项
	 *
	 * @param typeCode typeCode
	 * @return r
	 */
	List<DictItemVO> listAllByTypeCode(String typeCode);

	/**
	 * 分页查询字典项列表
	 *
	 * @param pageParam      pageParam
	 * @return r
	 */
	List<DictItemVO> page(DictItemPageParam pageParam);

	/**
	 * 一次性查询出所有字典项数据
	 *
	 * @return r
	 */
	List<DictItemVO> listAll();
}