package ${basePackageName}.${subPackageName}.domain.db;

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
<#if pageFlag == true>
@EqualsAndHashCode(callSuper = true)
</#if>
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "${tableName}")
public class ${tableNameHump}DO <#if pageFlag == true> extends BaseDO </#if>{
<#if pageFlag == false>
	/**
	 * ${tableComment}ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
</#if>

<#list columnList as column>
    <#if column.columnNameHumpLetter != "id" && column.columnNameHumpLetter != "createTime" && column.columnNameHumpLetter != "updateTime">
	/**
	 * ${column.columnComment}
	 */
	@TableField(value = "${column.columnName}")
	private ${column.columnTypeJava} ${column.columnNameHumpLetter};

    <#elseif pageFlag == false && column.columnNameHumpLetter == "createTime">
	/**
	 * ${column.columnComment}
	 */
	@TableField(value = "${column.columnName}")
	private LocalDateTime createTime;

    <#elseif pageFlag == false && column.columnNameHumpLetter == "updateTime">
	/**
	 * ${column.columnComment}
	 */
	@TableField(value = "${column.columnName}")
	private LocalDateTime updateTime;
    </#if>
</#list>
}