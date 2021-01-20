package ${basePackageName}.${subPackageName}.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${basePackageName}.${subPackageName}.domain.db.${tableNameHump}DO;
<#if pageFlag ??>
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}PageParam;
import ${basePackageName}.${subPackageName}.domain.vo.${tableNameHump}VO;
</#if>

import java.util.List;

public interface ${tableNameHump}Mapper extends BaseMapper<${tableNameHump}DO> {

<#if pageFlag == true>
	/**
	 * 分页查询${tableComment}列表
	 *
	 * @param param param
	 * @return r
	 */
	List<${tableNameHump}VO> page(${tableNameHump}PageParam param);
</#if>

}