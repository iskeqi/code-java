package ${basePackageName}.${subPackageName}.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
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

import java.util.List;

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
		${tableNameHump}DO t = BeanUtil.copyProperties(param, ${tableNameHump}DO.class);
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
		${tableNameHump}DO t = BeanUtil.copyProperties(param, ${tableNameHump}DO.class);
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
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<${tableNameHump}VO> result = this.deptMapper.page(param);

		return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
	}
}
