package ${basePackageName}.${subPackageName}.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

<#if hasBigDecimal ??>
import java.math.BigDecimal;
</#if>
<#if hasLocalDateTime ??>
import java.time.LocalDateTime;
</#if>
<#if hasLocalDate ??>
import java.time.LocalDate;
</#if>
<#if hasMap ??>
import java.util.Map;
</#if>

/**
 * ${tableComment}表
 */
@Data
public class ${tableNameHump} {

<#list columnList as column>
	/**
	 * ${column.columnComment}
	 */
	@ApiModelProperty(value = "id", example = "1", required = true)
	private ${column.columnTypeJava} ${column.columnNameHumpLetter};

</#list>
}