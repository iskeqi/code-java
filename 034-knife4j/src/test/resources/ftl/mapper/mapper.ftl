package ${basePackageName}.${subPackageName}.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${basePackageName}.${subPackageName}.domain.db.${tableNameHump}DO;
<#if pageFlag ??>
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}PageParam;
import ${basePackageName}.${subPackageName}.domain.vo.${tableNameHump}VO;
</#if>
import org.apache.ibatis.annotations.Param;

public interface ${tableNameHump}Mapper extends BaseMapper<${tableNameHump}DO> {

<#if pageFlag == true>
	/**
	 * 分页查询${tableComment}列表
	 *
	 * @param param param
	 * @return r
	 */
	IPage<${tableNameHump}VO> page(@Param("page") IPage<${tableNameHump}VO> page, @Param("param") ${tableNameHump}PageParam param);
</#if>

}