package ${packageName}.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import ${basePackageName}.core.pojo.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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

/**
 * ${tableComment}表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "${tableName}")
public class ${tableNameHump}DO extends BaseDO {

<#list columnList as column>
<#if column.columnNameHump != "id" && column.columnNameHump != "createTime" && column.columnNameHump != "updateTime">
	/**
	 * ${column.columnComment}
	 */
	@TableField(value = "${column.columnName}")
	private ${column.columnTypeJava} ${column.columnNameHump};

</#if>
</#list>
}