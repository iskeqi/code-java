package com.keqi.seed.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.param.ParamConfigPageParam;
import com.keqi.seed.sys.domain.param.ParamConfigParam;
import com.keqi.seed.sys.domain.vo.ParamConfigVO;
import com.keqi.seed.sys.service.ParamConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "7. 参数配置管理")
@ApiSupport(order = 7)
@RestController
public class ParamConfigController {

	@Autowired
	private ParamConfigService paramConfigService;

	@ApiOperation(value = "7.1 新增参数配置")
	@ApiOperationSupport(order = 1, ignoreParameters = "param.id")
	@PostMapping("/sys/paramConfig")
	public void insert(@Validated @RequestBody ParamConfigParam param) {
		this.paramConfigService.insert(param);
	}

	@ApiOperation(value = "7.2 修改参数配置")
	@ApiOperationSupport(order = 2)
	@PutMapping("/sys/paramConfig")
	public void updateById(@Validated @RequestBody ParamConfigParam param) {
		this.paramConfigService.updateById(param);
	}

	@ApiOperation(value = "7.3 删除参数配置")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "参数配置ID", example = "1", required = true)
	@DeleteMapping("/sys/paramConfig/{id}")
	public void deleteById(@PathVariable Long id) {
		this.paramConfigService.deleteById(id);
	}

	@ApiOperation(value = "7.4 分页查询参数配置列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/paramConfig/page")
	public PageVO<ParamConfigVO> page(@RequestBody ParamConfigPageParam param) {
		return this.paramConfigService.page(param);
	}
}