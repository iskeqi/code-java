package ${basePackageName}.${subPackageName}.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${basePackageName}.core.pojo.PageVO;
import ${basePackageName}.${subPackageName}.domain.db.${tableNameHump}DO;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}PageParam;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}Param;
import ${basePackageName}.${subPackageName}.domain.vo.${tableNameHump}VO;
import ${basePackageName}.${subPackageName}.mapper.${tableNameHump}Mapper;
import ${basePackageName}.${subPackageName}.service.${tableNameHump}Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ${tableNameHump}ServiceImpl implements ${tableNameHump}Service {

	private final ${tableNameHump}Mapper ${tableNameHumpLetter}Mapper;

	/**
	 * 新增${tableComment}
	 *
	 * @param ${tableNameHumpLetter}Param ${tableNameHumpLetter}Param
	 */
	@Override
	@Transactional
	public void insert(${tableNameHump}Param ${tableNameHumpLetter}Param) {
		${tableNameHump}DO t = new ${tableNameHump}DO();
		BeanUtil.copyProperties(${tableNameHumpLetter}Param, t);

		this.${tableNameHumpLetter}Mapper.insert(t);
	}

	/**
	 * 根据ID修改${tableComment}
	 *
	 * @param ${tableNameHumpLetter}Param ${tableNameHumpLetter}Param
	 */
	@Override
	@Transactional
	public void updateById(${tableNameHump}Param ${tableNameHumpLetter}Param) {
		${tableNameHump}DO t = new ${tableNameHump}DO();
		BeanUtil.copyProperties(${tableNameHumpLetter}Param, t);

		this.${tableNameHumpLetter}Mapper.updateById(t);
	}

	/**
	 * 根据ID删除${tableComment}
	 *
	 * @param id id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {
		this.${tableNameHumpLetter}Mapper.deleteById(id);
	}

	/**
	 * 分页查询${tableComment}列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	@Override
	public PageVO<${tableNameHump}VO> page(${tableNameHump}PageParam pageParam) {
		Page<${tableNameHump}VO> page = new Page<>(pageParam.getCurrent(), pageParam.getSize());
		IPage<${tableNameHump}VO> result = this.${tableNameHumpLetter}Mapper.page(page, pageParam);

		return new PageVO<>(result.getTotal(), result.getRecords());
	}
}
