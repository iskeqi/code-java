package ${basePackageName}.${subPackageName}.domain.param;

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

@Data
public class ${tableNameHump}Param {

<#list columnList as column>
    <#if column.columnNameHumpLetter != "createTime" && column.columnNameHumpLetter != "updateTime">
    private ${column.columnTypeJava} ${column.columnNameHumpLetter};

    </#if>
</#list>
}