package com.keqi.springbootmybatisplusmysql.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.springbootmybatisplusmysql.common.AjaxEntity;
import com.keqi.springbootmybatisplusmysql.domain.CodeGenDO;
import com.keqi.springbootmybatisplusmysql.domain.CodeGenVO;
import com.keqi.springbootmybatisplusmysql.domain.PageCodeGenParam;
import com.keqi.springbootmybatisplusmysql.mapper.CodeGenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/code-gen")
public class CodeGenController {

	@Autowired
	private CodeGenMapper codeGenMapper;

	/**
	 * 增加
	 *
	 * @param codeGenDO codeGenDO
	 * @return ajaxEntity
	 */
	@PostMapping("/save")
	public AjaxEntity addCodeGen(CodeGenDO codeGenDO) {
		codeGenMapper.insert(codeGenDO);
		return AjaxEntity.success("id", codeGenDO.getId());
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
		codeGenMapper.deleteBatchIds(Arrays.asList(ids));
		return AjaxEntity.success();
	}

	/**
	 * 修改
	 *
	 * @param codeGenDO codeGenDO
	 * @return ajaxEntity
	 */
	@PostMapping("/update")
	public AjaxEntity updateCodeGen(CodeGenDO codeGenDO) {
		codeGenMapper.updateById(codeGenDO);
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
		CodeGenDO codeGenDO = codeGenMapper.selectById(id);
		CodeGenVO codeGenVO = new CodeGenVO();
		BeanUtil.copyProperties(codeGenDO, codeGenVO);
		return AjaxEntity.success(codeGenVO);
	}

	/**
	 * 查询列表
	 *
	 * @param codeGenVO codeGenVO
	 * @param current   页数
	 * @param size      大小
	 * @return list
	 */
	@PostMapping("/list")
	public AjaxEntity listCodeGen(CodeGenVO codeGenVO, long current, long size) {

		LambdaQueryWrapper<CodeGenDO> lambdaQueryWrapper = new LambdaQueryWrapper<CodeGenDO>()
				.ge(CodeGenDO::getAge, codeGenVO.getAge())
				.orderByDesc(CodeGenDO::getUpdateTime);


		Page<CodeGenDO> codeGenDOPage = codeGenMapper.selectPage(new Page<>(current, size), lambdaQueryWrapper);

		// 如果不希望所有的字段都返回给客户端，是应该在这里遍历结果，然后转成VO对象返回到客户端吗？
		List<CodeGenVO> ret = new ArrayList<>();
		codeGenDOPage.getRecords().forEach(
				x -> {
					CodeGenVO c = new CodeGenVO();
					BeanUtil.copyProperties(x, c);
					ret.add(c);
				}
		);

		return AjaxEntity.list(codeGenDOPage.getTotal(), ret);
	}

	/**
	 * 测试自定义分页功能
	 */
	@GetMapping("/page")
	public AjaxEntity listCodeGen() {
		PageCodeGenParam param = new PageCodeGenParam();
		param.setSearchValue("j");

		// 直接将本接口的参数类继承 MyBatisPlus 提供的 Page 类即可
		// 查询出来的 List 数据也是在这里面的
		// 使用 MyBatisPlus 提供的分页插件就这么简单

		// 方法一：推荐，直接新建一个分页查询参数类（包含了 current 和 size 两个参数）
		// 并使用 IPage 作为分页查询方法的返回值，在调用方法时，new 一个 Page 对象，把两个参数传递进去，第二个参数才是自己的参数
		IPage<CodeGenDO> page4 = this.codeGenMapper.page4(new Page<>(1, 10), param);


		// 法二：推荐，如果没有用 swagger 来写接口文档，那么完全可继承 Page 对象，只使用一个参数从 controller -> service -> mapper 即可
		IPage<CodeGenDO> page = this.codeGenMapper.page1(param);

		// 方法三：不推荐
		List<CodeGenDO> list = this.codeGenMapper.page2(param);

		// 方法四：不推荐
		Page<CodeGenDO> page3 = new Page(1,2);
		List<CodeGenDO> list1 = this.codeGenMapper.page3(page3, null);

		return AjaxEntity.list(page3.getTotal(), list1);
	}

}
