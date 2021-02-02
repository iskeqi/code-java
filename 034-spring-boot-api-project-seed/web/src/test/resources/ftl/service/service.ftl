package ${basePackageName}.${subPackageName}.service;

import ${basePackageName}.core.pojo.PageVO;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}PageParam;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}Param;
import ${basePackageName}.${subPackageName}.domain.vo.${tableNameHump}VO;

public interface ${tableNameHump}Service {

	void insert(${tableNameHump}Param param);

	void updateById(${tableNameHump}Param param);

	void deleteById(Long id);

	PageVO<${tableNameHump}VO> page(${tableNameHump}PageParam param);
}