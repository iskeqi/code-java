package com.keqi.seed.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.param.DictItemPageParam;
import com.keqi.seed.sys.domain.param.DictItemParam;
import com.keqi.seed.sys.domain.vo.DictItemVO;
import com.keqi.seed.sys.service.DictItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "2. 字典项管理")
@ApiSupport(order = 2)
@RestController
public class DictItemController {

	@Autowired
	private DictItemService dictItemService;

	@ApiOperation(value = "2.1 新增字典项")
	@ApiOperationSupport(order = 1, ignoreParameters = "param.id")
	@PostMapping("/sys/dictItem")
	public void insert(@RequestBody DictItemParam param) {
		this.dictItemService.insert(param);
	}

	@ApiOperation(value = "2.2 修改字典项")
	@ApiOperationSupport(order = 2)
	@PutMapping("/sys/dictItem")
	public void updateById(@RequestBody DictItemParam param) {
		this.dictItemService.updateById(param);
	}

	@ApiOperation(value = "2.3 删除字典项")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "字典项ID", example = "1", required = true)
	@DeleteMapping("/sys/dictItem/{id}")
	public void deleteById(@PathVariable Long id) {
		this.dictItemService.deleteById(id);
	}

	@ApiOperation(value = "2.4 分页查询字典项列表")
	@ApiOperationSupport(order = 4)
	@GetMapping("/sys/dictItem/page")
	public PageVO<DictItemVO> page(DictItemPageParam param) {
		return this.dictItemService.page(param);
	}

	@ApiOperation(value = "2.5 根据 typeCode 查询字典项列表")
	@ApiOperationSupport(order = 5)
	@ApiImplicitParam(name = "typeCode", value = "字典类型Code", example = "configType", required = true)
	@GetMapping("/sys/dictItem/listAllByTypeCode")
	public List<DictItemVO> listAllByTypeCode(@RequestParam String typeCode) {
		return this.dictItemService.selectByTypeCode(typeCode);
	}
}
