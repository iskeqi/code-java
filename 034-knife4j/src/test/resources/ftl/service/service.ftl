package ${packageName}.service;

import ${basePackageName}.core.pojo.PageVO;
import ${packageName}.domain.param.${tableNameHump}PageParam;
import ${packageName}.domain.param.${tableNameHump}Param;
import ${packageName}.domain.vo.${tableNameHump}VO;

public interface ${tableNameHump}Service {

	/**
	 * 新增${tableComment}
	 *
	 * @param ${tableNameHumpLetter}Param ${tableNameHumpLetter}Param
	 */
	void insert(${tableNameHump}Param ${tableNameHumpLetter}Param);

	/**
	 * 根据ID修改${tableComment}
	 *
	 * @param ${tableNameHumpLetter}Param ${tableNameHumpLetter}Param
	 */
	void updateById(${tableNameHump}Param ${tableNameHumpLetter}Param);

	/**
	 * 根据ID删除${tableComment}
	 *
	 * @param id id
	 */
	void deleteById(Long id);

	/**
	 * 分页查询${tableComment}列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	PageVO<${tableNameHump}VO> page(${tableNameHump}PageParam pageParam);
}