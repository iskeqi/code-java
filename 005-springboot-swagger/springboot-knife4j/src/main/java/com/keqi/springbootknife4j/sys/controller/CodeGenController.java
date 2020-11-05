package com.keqi.springbootknife4j.sys.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import com.keqi.springbootknife4j.common.AjaxEntity;
import com.keqi.springbootknife4j.common.AjaxEntityBuilder;
import com.keqi.springbootknife4j.common.AjaxPageEntity;
import com.keqi.springbootknife4j.sys.domain.*;
import com.keqi.springbootknife4j.sys.mapper.CodeGenMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Api(tags = "1. 代码生成管理")
@ApiSupport(order = 1, author = "keqi")
@RestController
@RequestMapping(value = "/code-gen"/*, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE*/)
@AllArgsConstructor
public class CodeGenController {

	private final CodeGenMapper codeGenMapper;

	/*
	一、用在 Controller 类上的注解：

		@Api
			作用：用在 Controller 类上方，填写 Controller 类中所有接口的总的信息，也就是分组的信息
			属性：
				tags：填写分组的名称

		@ApiSupport
			作用：用于给同一个包下的多个 Controller 类进行排序
			属性：
				order：指定 Controlelr 的顺序，默认是从小到大的
				author：用于指定这个 Controller 中所有接口的作者，这样就不需要使用 @ApiOperationSupport 注解在每个方法上都声明了
						如果两个注解的 author 不同的话，以范围小的那个为准（也就是 @ApiOperationSupport 指定的那个 auhor 属性）

	二、用在 Controller 方法上的注解：

		@ApiOperation
			作用：用在 Controller 接口上方，填写接口的描述信息
			属性：
				value：填写接口名称（肯定是必填啊）
				notes：填写接口的备注信息，有时候需要额外的信息来描述一个接口。（不是必填项，如果不填写，UI 界面上就不会有 "接口描述" 这一项）

		@ApiOperationSupport
			注解：用在 Controller 接口上方，用于给一个 Controller 中的接口在 UI 界面上进行排序
			属性：
				order：指定接口的顺序，默认是从小到大的
				author：指定接口的作者（不是必填项，如果不填写，UI 界面上就不会出现 "开发者" 这一项）
	 */


	@ApiOperation(value = "1.1 增加代码生成"/*, notes = "接口备注"*/)
	@ApiOperationSupport(order = 1, author = "keqi123") // 指定接口的排序
	@PostMapping(value = "/save")
	public AjaxEntity<?> addCodeGen(@RequestBody CodeGenSaveParam codeGenSaveParam) {
		CodeGenDO codeGenDO = new CodeGenDO();
		BeanUtil.copyProperties(codeGenSaveParam, codeGenDO);
		codeGenMapper.insert(codeGenDO);
		return AjaxEntityBuilder.success();
	}


	@ApiOperation(value = "1.2 批量删除代码生成", notes = "接口备注")
	@ApiOperationSupport(order = 2)
	@PostMapping(value = "/remove")
	@Transactional
	public AjaxEntity<?> deleteCodeGen(@RequestBody Integer[] ids) {
		codeGenMapper.deleteBatchIds(Arrays.asList(ids));
		return AjaxEntityBuilder.success();
	}

	@ApiOperation(value = "1.3 修改代码生成", notes = "接口备注")
	@PostMapping(value = "/update")
	@ApiOperationSupport(order = 3)
	public AjaxEntity<?> updateCodeGen(@RequestBody CodeGenUpdateParam codeGenUpdateParam) {
		CodeGenDO codeGenDO = new CodeGenDO();
		BeanUtil.copyProperties(codeGenUpdateParam, codeGenDO);
		codeGenMapper.updateById(codeGenDO);
		return AjaxEntityBuilder.success();
	}

	@ApiOperation(value = "1.4 查询单个代码生成", notes = "接口备注")
	@ApiOperationSupport(
			order = 4,
			params = @DynamicParameters(properties = {
						@DynamicParameter(name = "id", value = "主键", required = true, example = "8", dataTypeClass = Integer.class)
	}))
	@PostMapping(value = "/get")
	public AjaxEntity<CodeGenVO> getCodeGen(@RequestBody Map<String, Object> param) {
		// 极个别参数时这么做就行
		CodeGenDO codeGenDO = codeGenMapper.selectById(MapUtil.getLong(param, "id"));
		CodeGenVO codeGenVO = new CodeGenVO();
		BeanUtil.copyProperties(codeGenDO, codeGenVO);
		return AjaxEntityBuilder.success(codeGenVO);
	}

	@ApiOperation(value = "1.5 查询列表代码生成", notes = "接口备注")
	@ApiOperationSupport(order = 5)
	@PostMapping("/page")
	public AjaxPageEntity<CodeGenVO> listCodeGen(@RequestBody CodeGenPageParam codeGenPageParam) {

		LambdaQueryWrapper<CodeGenDO> lambdaQueryWrapper = new LambdaQueryWrapper<CodeGenDO>()
				.ge(CodeGenDO::getAge, codeGenPageParam.getAge())
				.ge(CodeGenDO::getAge, codeGenPageParam.getAge())
				.ge(CodeGenDO::getAge, codeGenPageParam.getAge())
				.orderByDesc(CodeGenDO::getUpdateTime);

		Page<CodeGenDO> codeGenDOPage = codeGenMapper.selectPage(new Page<>(codeGenPageParam.getCurrent(), codeGenPageParam.getSize()),
				lambdaQueryWrapper);

		// 把查询出来的DO转成VO
		List<CodeGenVO> ret = new ArrayList<>();
		codeGenDOPage.getRecords().forEach(
				x -> {
					CodeGenVO c = new CodeGenVO();
					BeanUtil.copyProperties(x, c);
					ret.add(c);
				}
		);

		return AjaxEntityBuilder.list(codeGenDOPage.getTotal(), ret);
	}

	/*

	总结：
		1、请求、响应参数全部都使用json，直接在Controller类的上面通过@RequestMapping注解指定即可
		2、请求参数只有一个或者两个时，直接用一个Map接收就行
		3、响应体中为了保持固定的层次结构，还是需要创建一个单独的VO，不论是多个参数还是只有一个参数时
		4、方法通过@ApiOperationSupport注解的order属性进行排序
		5、类通过@ApiSort注解进行排序
		6、记得熟读knife4j的文档



	 */



}
