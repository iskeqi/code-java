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
import com.keqi.springbootknife4j.common.PageEntitiy;
import com.keqi.springbootknife4j.sys.domain.*;
import com.keqi.springbootknife4j.sys.mapper.CodeGenMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
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

	三、用在请求参数和相应参数上的注解：

		@ApiModelProperty
			作用：用在请求参数或者相应参数实体类的属性中
			属性：
				value：指定属性的名称，直接会显示在 UI 界面上
				required：默认值是 flase，如果该参数是必须传递的，那么一定要设置此值为 true。同样会显示在 UI 界面上
				dataType：此注解中的解释是用来指定数据类型的，但是实际上在 knife4j 中指定了此属性反而不起作用，不指定反而能自动识别出来
				example：用于给定一个示例值，直接和 value 属性一同在 UI 界面上显示
				hidden：尽管编码规范要求 Param 类和 VO 类不允许出现额外的属性，但有时真的有点不可避免。
						那么就可以使用将 hidden 属性设置为 true，则不会再 UI 界面上显示出来

				至于如何保证字段在界面上的顺序，这个 knife4j 的作者明确说了暂不支持，后续好像也没有开发的计划

		@ApiImplicitParam
			作用：如果只有一两个参数时，懒得单独封装成一个实体类，那么就可以使用表单的方式提交，这时就可以使用此注解来标识请求参数
			属性：
				name：和 @RequestParam 注解 value 属性的值一样，也就是要和方法中形参名称一样（必须搭配此注解，否则不会生效）
				value：指定属性的名称，直接会显示在 UI 界面上
				example：用于给定一个示例值，直接和 value 属性一同在 UI 界面上显示
				required：默认值是 flase，如果该参数是必须传递的，那么一定要设置此值为 true。同样会显示在 UI 界面上

		@ApiImplicitParams
			作用：如果接口方法中只有一个参数，那么直接使用 @ApiImplicitParam 注解即可，如果有多个，那么就需要使用此注解
	 */

	/*
		此次学习仅仅是把常用的几种方式学习一下，更多的玩法肯定不是这样子学习的，等到了实际项目中需要用到时，再去 knife4j 的官方 demo 看，
		通过界面的展示和代码的使用，来进一步学习，然后整理成自己的笔记。demo：swagger-bootstrap-ui-demo

		其实总共就只有这几个注解需要掌握，也没啥其他的注解了
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
	// 为了使得能够自动的嵌套 List 列表并在 UI 界面上显示，只能这么干了
	// （可以在 PageEntity 中把 AjaxEntity 中的 3 个属性放在一起，这样就不需要套来套去了）
	public AjaxEntity<PageEntitiy<CodeGenVO>> listCodeGen(@RequestBody CodeGenPageParam codeGenPageParam) {

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
		return null; // 改成此种方式作为返回之后，需要配套准备一个返回值的便利方法
	}

	/**
	 * 查询指定字典类型下的全部列表
	 * @param typeCode typeCode
	 * @return r
	 */
	@ApiOperation(value = "1.6 查询字典项列表")
	@ApiOperationSupport(order = 6)
	@ApiImplicitParam(name = "typeCode", value = "字典类型code", example = "gender", required = true)
	@PostMapping("/page")
	public AjaxEntity page(@Validated @RequestParam String typeCode) {
		return AjaxEntityBuilder.success();
	}

	/**
	 * 用户自己修改密码
	 * @param oldPassword oldPassword
	 * @param newPassword newPassword
	 * @return r
	 */
	@ApiOperation(value = "1.7 用户修改密码")
	@ApiOperationSupport(order = 7)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "oldPassword", value = "旧密码", example = "123456", required = true),
			@ApiImplicitParam(name = "newPassword", value = "新密码", example = "123456", required = true)
	}
	)
	@PostMapping("/updatePassword")
	public AjaxEntity updatePassword(String oldPassword, String newPassword) {
		return AjaxEntityBuilder.success();
	}
	/*

	总结：
		1、请求、响应参数全部都使用json，直接在Controller类的上面通过@RequestMapping注解指定即可
		2、请求参数只有一个或者两个时，直接用一个Map接收就行
		3、响应体中为了保持固定的层次结构，还是需要创建一个单独的VO，不论是多个参数还是只有一个参数时
		4、方法通过@ApiOperationSupport注解的order属性进行排序
		5、类通过@ApiSupport注解进行排序
		6、记得熟读knife4j的文档



	 */



}
