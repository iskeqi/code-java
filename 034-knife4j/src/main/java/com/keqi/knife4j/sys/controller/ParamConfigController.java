package com.keqi.knife4j.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.ParamConfigPageParam;
import com.keqi.knife4j.sys.domain.param.ParamConfigParam;
import com.keqi.knife4j.sys.domain.vo.ParamConfigVO;
import com.keqi.knife4j.sys.service.ParamConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "7. 参数配置管理")
@ApiSupport(order = 7)
@AllArgsConstructor
@RestController
public class ParamConfigController {

	private final ParamConfigService paramConfigService;

	@ApiOperation(value = "7.1 新增参数配置")
	@ApiOperationSupport(order = 1, ignoreParameters = "paramConfigParam.id")
	@PostMapping("/sys/paramConfig")
	public void create(@Validated @RequestBody ParamConfigParam paramConfigParam) {
		this.paramConfigService.insert(paramConfigParam);
	}

	@ApiOperation(value = "7.2 修改参数配置")
	@ApiOperationSupport(order = 2)
	@PutMapping("/sys/paramConfig")
	public void updateById(@Validated @RequestBody ParamConfigParam paramConfigParam) {
		this.paramConfigService.updateById(paramConfigParam);
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
	public PageVO<ParamConfigVO> page(@RequestBody ParamConfigPageParam pageParam) {
		return this.paramConfigService.page(pageParam);
	}
}