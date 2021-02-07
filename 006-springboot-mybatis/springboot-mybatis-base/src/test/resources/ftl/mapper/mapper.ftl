package ${basePackageName}.${subPackageName}.mapper;

import ${basePackageName}.core.BaseMapper;
import ${basePackageName}.${subPackageName}.domain.db.${tableNameHump}DO;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}PageParam;
import ${basePackageName}.${subPackageName}.domain.vo.${tableNameHump}VO;

public interface ${tableNameHump}Mapper extends BaseMapper<${tableNameHump}DO, ${tableNameHump}VO, ${tableNameHump}PageParam> {

}