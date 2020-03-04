package com.qjzh.idomp.zjc.sc.controller;


import com.qjzh.idomp.zjc.core.common.AjaxEntity;
import com.qjzh.idomp.zjc.core.common.AjaxEntityBuilder;
import com.qjzh.idomp.zjc.sc.domain.DictData;
import com.qjzh.idomp.zjc.sc.service.DictDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
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

	private final DictDataService dictDataService;

	/**
	 * 根据dictType返回对应的字典数据列表
	 * @param dictType dictType
	 * @return list
	 */
	@GetMapping("/get/dict-type")
	public AjaxEntity pageDictData(String dictType) {
		return AjaxEntityBuilder.success(this.dictDataService.listByDictType(dictType));
	}

	/**
	 * 删除dictType对应的字典数据列表
	 * @param dictType dictType
	 * @return r
	 */
	@PostMapping("/delete/dict-type")
	public AjaxEntity deleteByDictType(@NotNull String dictType) {
		this.dictDataService.deleteByDictType(dictType);
		return AjaxEntityBuilder.success();
	}

	/**
	 * 批量增加字典数据
	 * @param dictDataList dictDataList
	 * @return r
	 */
	@PostMapping("/insert-batch")
	public AjaxEntity insertBatch(@RequestBody List<DictData> dictDataList) {
		this.dictDataService.insertBatch(dictDataList);
		return AjaxEntityBuilder.success();
	}
}
