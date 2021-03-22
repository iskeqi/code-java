package ${basePackageName}.${subPackageName}.dto;

import ${basePackageName}.${subPackageName}.entity.${tableNameHump};
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = true)
@Data
public class ${tableNameHump}Dto extends ${tableNameHump} {

}