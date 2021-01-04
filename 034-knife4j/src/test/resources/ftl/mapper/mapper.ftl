package ${basePackageName}.${subPackageName}.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${basePackageName}.${subPackageName}.domain.db.${tableNameHump}DO;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}PageParam;
import ${basePackageName}.${subPackageName}.domain.vo.${tableNameHump}VO;
import org.apache.ibatis.annotations.Param;

public interface ${tableNameHump}Mapper extends BaseMapper<${tableNameHump}DO> {

	/**
     * 分页查询${tableComment}列表
     *
     * @param page page
     * @return r
     */
	IPage<${tableNameHump}VO> page(@Param("page") IPage<?> page, @Param("param") ${tableNameHump}PageParam param);

}