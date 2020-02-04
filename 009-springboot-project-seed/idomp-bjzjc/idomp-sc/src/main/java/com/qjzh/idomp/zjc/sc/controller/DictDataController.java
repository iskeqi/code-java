package com.qjzh.idomp.zjc.sc.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qjzh.idomp.zjc.core.common.AjaxEntity;
import com.qjzh.idomp.zjc.core.common.AjaxEntityBuilder;
import com.qjzh.idomp.zjc.sc.domain.DictDataDO;
import com.qjzh.idomp.zjc.sc.domain.DictDataVO;
import com.qjzh.idomp.zjc.sc.service.IDictDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 字典数据表 前端控制器
 * </p>
 *
 * @author keqi
 * @since 2020-02-03
 */
@RestController
@RequestMapping("/sc/dict-data")
@AllArgsConstructor
public class DictDataController {

	private final IDictDataService iDictDataService;

	/**
	 * 根据dictType得值返回对应的字典数据列表
	 * @param dictType dictType
	 * @return list
	 */
	@GetMapping("/dict-type")
	public AjaxEntity<DictDataVO> pageDictData(String dictType) {

		// 1、查询指定dictType对应的字典数据列表
		LambdaQueryWrapper<DictDataDO> lambdaQueryWrapper = new LambdaQueryWrapper<DictDataDO>()
				.eq(DictDataDO::getDictType, dictType)
				.eq(DictDataDO::getStatus, 0)
				.orderByAsc(DictDataDO::getDictSort);
		List<DictDataDO> list = iDictDataService.list(lambdaQueryWrapper);

		// 2、组装返回VO对象
		List<DictDataVO> ret = new ArrayList<>();
		list.forEach(
				x -> {
					DictDataVO c = new DictDataVO();
					BeanUtil.copyProperties(x, c);
					ret.add(c);
				}
		);

		return AjaxEntityBuilder.success(ret);
	}
}
