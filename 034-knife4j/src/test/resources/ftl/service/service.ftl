package ${basePackageName}.${subPackageName}.service;

import ${basePackageName}.core.pojo.PageVO;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}PageParam;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}Param;
import ${basePackageName}.${subPackageName}.domain.vo.${tableNameHump}VO;

public interface ${tableNameHump}Service {

	/**
	 * 新增${tableComment}
	 *
	 * @param param param
	 */
	void insert(${tableNameHump}Param param);

	/**
	 * 修改${tableComment}
	 *
	 * @param param param
	 */
	void updateById(${tableNameHump}Param param);

	/**
	 * 删除${tableComment}
	 *
	 * @param id id
	 */
	void deleteById(Long id);

	/**
	 * 分页查询${tableComment}列表
	 *
	 * @param param param
	 * @return r
	 */
	PageVO<${tableNameHump}VO> page(${tableNameHump}PageParam param);
}