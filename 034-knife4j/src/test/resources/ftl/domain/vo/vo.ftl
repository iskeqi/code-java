package ${basePackageName}.${subPackageName}.domain.vo;

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
public class ${tableNameHump}VO {

<#list columnList as column>
    @ApiModelProperty(value = "${column.columnComment}", example = "")
    private ${column.columnTypeJava} ${column.columnNameHumpLetter};

</#list>
}