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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ${tableNameHump}ServiceImpl implements ${tableNameHump}Service {

	@Autowired
	private ${tableNameHump}Mapper ${tableNameHumpLetter}Mapper;

	/**
	 * 新增${tableComment}
	 *
	 * @param param param
	 */
	@Override
	@Transactional
	public void insert(${tableNameHump}Param param) {
		${tableNameHump}DO t = new ${tableNameHump}DO();
		BeanUtil.copyProperties(param, t);

		this.${tableNameHumpLetter}Mapper.insert(t);
	}

	/**
	 * 修改${tableComment}
	 *
	 * @param param param
	 */
	@Override
	@Transactional
	public void updateById(${tableNameHump}Param param) {
		${tableNameHump}DO t = new ${tableNameHump}DO();
		BeanUtil.copyProperties(param, t);

		this.${tableNameHumpLetter}Mapper.updateById(t);
	}

	/**
	 * 删除${tableComment}
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
	 * @param param param
	 * @return r
	 */
	@Override
	public PageVO<${tableNameHump}VO> page(${tableNameHump}PageParam param) {
		Page<${tableNameHump}VO> page = new Page<>(param.getCurrent(), param.getSize());
		IPage<${tableNameHump}VO> result = this.${tableNameHumpLetter}Mapper.page(page, param);

		return new PageVO<>(result.getTotal(), result.getRecords());
	}
}
