package ${packageName}.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${basePackageName}.core.pojo.PageVO;
import ${packageName}.domain.param.${tableNameHump}PageParam;
import ${packageName}.domain.param.${tableNameHump}Param;
import ${packageName}.domain.vo.${tableNameHump}VO;
import ${packageName}.mapper.${tableNameHump}Mapper;
import ${packageName}.service.${tableNameHump}Service;
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

	}

	/**
	 * 根据ID修改${tableComment}
	 *
	 * @param ${tableNameHumpLetter}Param ${tableNameHumpLetter}Param
	 */
	@Override
	@Transactional
	public void updateById(${tableNameHump}Param ${tableNameHumpLetter}Param) {

	}

	/**
	 * 根据ID删除${tableComment}
	 *
	 * @param id id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {

	}

	/**
	 * 分页查询${tableComment}列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	@Override
	public PageVO<${tableNameHump}VO> page(${tableNameHump}PageParam pageParam) {

		return null;
	}
}
