package com.keqi.hcttopgenerate.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.keqi.hcttopgenerate.entity.DictItem;
import com.keqi.hcttopgenerate.dto.DictItemDto;
import com.keqi.hcttopgenerate.service.DictItemService;
import com.hcttop.ssm.common.BaseController;
import com.hcttop.ssm.common.PageData;
import com.hcttop.ssm.common.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "字典管理")
@RequestMapping("/api/task")
@RestController
public class DictItemController extends BaseController {

	@Autowired
	private DictItemService dictItemService;

	@ApiOperation(value = "新增字典")
	@ApiOperationSupport(order = 1, ignoreParameters = "param.id")
	@PostMapping("/sys/dictItem")
	public void insert(@RequestBody DictItem param) {
		this.dictItemService.insert(param);
	}

	@ApiOperation(value = "删除字典")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "字典ID", example = "1", required = true)
	@DeleteMapping("/sys/dictItem/{id}")
	public void removeById(@PathVariable Long id) {
		this.dictItemService.removeById(id);
	}

	@ApiOperation(value = "修改字典")
	@ApiOperationSupport(order = 2)
	@PutMapping("/sys/dictItem")
	public void update(@Validated @RequestBody DictItem param) {
		this.dictItemService.update(param);
	}

	@ApiOperation(value = "分页查询字典列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/dictItem/pageQuery")
	public PageData<DictItemDto> pageQuery(PageRequest pageRequest) {
		DictItemDto dictItemDto = new DictItemDto();
		// BeanUtil.copyProperties(param, dictItemDto);

		PageData<DictItemDto> pageData = new PageData<>(pageRequest, dictItemDto);

		return this.dictItemService.pageQuery(pageData);
	}
}