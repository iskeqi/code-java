package com.keqi.spirngbootdictdb.controller;

import com.keqi.spirngbootdictdb.common.AjaxEntity;
import com.keqi.spirngbootdictdb.common.AjaxEntityBuilder;
import com.keqi.spirngbootdictdb.service.DictService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Validated
@AllArgsConstructor
public class DictController {

	private final DictService dictService;

	/**
	 * 查询dictType对应的字典数据
	 * @param dictType dictType
	 * @return r
	 */
	@GetMapping("/sc/dict/listDictByDictType")
	public AjaxEntity listDictByDictType(@NotNull String dictType) {
		return AjaxEntityBuilder.successList(this.dictService.listDictByDictType(dictType));
	}

	/**
	 * 批量新增
	 * @return
	 */
	public AjaxEntity insertBatch() {
		return AjaxEntityBuilder.success();
	}
}
