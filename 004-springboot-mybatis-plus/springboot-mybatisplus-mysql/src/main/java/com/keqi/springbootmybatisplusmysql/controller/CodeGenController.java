package com.keqi.springbootmybatisplusmysql.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.keqi.springbootmybatisplusmysql.common.AjaxEntity;
import com.keqi.springbootmybatisplusmysql.domain.CodeGenDO;
import com.keqi.springbootmybatisplusmysql.domain.CodeGenVO;
import com.keqi.springbootmybatisplusmysql.mapper.CodeGenMapper;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/code-gen")
@AllArgsConstructor
public class CodeGenController {

	private final CodeGenMapper codeGenMapper;


	@PostMapping("/add")
	public AjaxEntity addCodeGen(CodeGenVO codeGenVO) {
		CodeGenDO codeGenDO = new CodeGenDO();
		BeanUtil.copyProperties(codeGenVO, codeGenDO);
		codeGenMapper.insert(codeGenDO);
		return AjaxEntity.success();
	}

	@PostMapping("/delete")
	@Transactional
	public AjaxEntity deleteCodeGen(@RequestBody Integer[] ids) {
		codeGenMapper.deleteBatchIds(Arrays.asList(ids));
		return AjaxEntity.success();
	}

	@PostMapping("/update")
	public AjaxEntity updateCodeGen(@Validated CodeGenVO codeGenVO) {
		CodeGenDO codeGenDO = new CodeGenDO();
		BeanUtil.copyProperties(codeGenVO, codeGenDO);
		codeGenMapper.updateById(codeGenDO);
		return AjaxEntity.success();
	}

	@PostMapping("/list")
	public AjaxEntity listCodeGen(CodeGenVO codeGenVO) {
		LambdaQueryWrapper<CodeGenDO> lambdaQueryWrapper = new LambdaQueryWrapper<CodeGenDO>()
				.eq(CodeGenDO::getUsername, codeGenVO.getUsername());

		codeGenMapper.selectCount(lambdaQueryWrapper);


		CodeGenDO codeGenDO = new CodeGenDO();
		BeanUtil.copyProperties(codeGenVO, codeGenDO);
		codeGenMapper.insert(codeGenDO);
		return AjaxEntity.success();
	}

}
