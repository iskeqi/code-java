package com.keqi.springbootmybatisplusmysql.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.springbootmybatisplusmysql.common.AjaxEntity;
import com.keqi.springbootmybatisplusmysql.domain.CodeGenDbDO;
import com.keqi.springbootmybatisplusmysql.domain.CodeGenDbVO;
import com.keqi.springbootmybatisplusmysql.mapper.CodeGenDbMapper;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/code-gen-db")
@AllArgsConstructor
public class CodeGenDbController {

	private final CodeGenDbMapper codeGenDbMapper;

	/**
	 * 增加
	 *
	 * @param codeGenDbDO codeGenDO
	 * @return ajaxEntity
	 */
	@PostMapping("/save")
	public AjaxEntity addCodeGen(CodeGenDbDO codeGenDbDO) {
		codeGenDbMapper.insert(codeGenDbDO);
		return AjaxEntity.success("id", codeGenDbDO.getId());
	}

	/**
	 * 批量删除
	 *
	 * @param ids ids
	 * @return ajaxEntity
	 */
	@PostMapping("/remove")
	@Transactional
	public AjaxEntity deleteCodeGen(@RequestBody Integer[] ids) {
		codeGenDbMapper.deleteBatchIds(Arrays.asList(ids));
		return AjaxEntity.success();
	}

	/**
	 * 修改
	 *
	 * @param codeGenDbDO codeGenDO
	 * @return ajaxEntity
	 */
	@PostMapping("/update")
	public AjaxEntity updateCodeGen(CodeGenDbDO codeGenDbDO) {
		codeGenDbMapper.updateById(codeGenDbDO);
		return AjaxEntity.success();
	}

	/**
	 * 查询单个
	 *
	 * @param id id
	 * @return ajaxEntity
	 */
	@GetMapping("/get/{id}")
	public AjaxEntity getCodeGen(@PathVariable Long id) {
		CodeGenDbDO codeGenDbDO = codeGenDbMapper.selectById(id);
		CodeGenDbVO codeGenDbVO = new CodeGenDbVO();
		BeanUtil.copyProperties(codeGenDbDO, codeGenDbVO);
		return AjaxEntity.success(codeGenDbVO);
	}

	/**
	 * 查询列表
	 *
	 * @param codeGenDbVO codeGenVO
	 * @param current   页数
	 * @param size      大小
	 * @return list
	 */
	@PostMapping("/list")
	public AjaxEntity listCodeGen(CodeGenDbVO codeGenDbVO, long current, long size) {

		LambdaQueryWrapper<CodeGenDbDO> lambdaQueryWrapper = new LambdaQueryWrapper<CodeGenDbDO>()
				.ge(CodeGenDbDO::getAge, codeGenDbVO.getAge())
				.orderByDesc(CodeGenDbDO::getUpdateTime);

		Page<CodeGenDbDO> codeGenDbDOPage = codeGenDbMapper.selectPage(new Page<>(current, size), lambdaQueryWrapper);

		// 如果不希望所有的字段都返回给客户端，是应该在这里遍历结果，然后转成VO对象返回到客户端吗？
		List<CodeGenDbVO> ret = new ArrayList<>();
		codeGenDbDOPage.getRecords().forEach(
				x -> {
					CodeGenDbVO c = new CodeGenDbVO();
					BeanUtil.copyProperties(x, c);
					ret.add(c);
				}
		);

		return AjaxEntity.list(codeGenDbDOPage.getTotal(), ret);
	}

}
