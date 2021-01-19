package ${basePackageName}.${subPackageName}.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @ApiModelProperty(value = "${column.columnComment}", example = "", required = true)
    private ${column.columnTypeJava} ${column.columnNameHumpLetter};

    </#if>
</#list>
}