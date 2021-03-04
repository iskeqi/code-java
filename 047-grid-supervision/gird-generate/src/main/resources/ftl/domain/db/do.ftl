package ${basePackageName}.${subPackageName}.domain.db;

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
public class ${tableNameHump}DO {

<#list columnList as column>
	/**
	 * ${column.columnComment}
	 */
	private ${column.columnTypeJava} ${column.columnNameHumpLetter};

</#list>
}