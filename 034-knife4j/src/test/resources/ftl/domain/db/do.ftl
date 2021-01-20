package ${basePackageName}.${subPackageName}.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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

/**
 * ${tableComment}表
 */
@Data
@TableName(value = "${tableName}")
public class ${tableNameHump}DO {

<#list columnList as column>
    <#if column.columnNameHumpLetter != "id" && column.columnNameHumpLetter != "createTime" && column.columnNameHumpLetter != "updateTime">
	/**
	 * ${column.columnComment}
	 */
	@TableField(value = "${column.columnName}")
	private ${column.columnTypeJava} ${column.columnNameHumpLetter};

	<#elseif column.columnNameHumpLetter == "id">
	/**
	 * ${tableComment}id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

    <#elseif column.columnNameHumpLetter == "createTime">
	/**
	 * ${column.columnComment}
	 */
	@TableField(value = "${column.columnName}", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

    <#elseif column.columnNameHumpLetter == "updateTime">
	/**
	 * ${column.columnComment}
	 */
	@TableField(value = "${column.columnName}", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;
    </#if>
</#list>
}