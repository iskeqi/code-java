package ${basePackageName}.${subPackageName}.domain.vo;

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

@Data
public class ${tableNameHump}VO {

<#list columnList as column>
    private ${column.columnTypeJava} ${column.columnNameHumpLetter};

</#list>
}