package com.keqi.knife4j;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用 FreeMarker 模板技术生成代码
 *
 * @author keqi
 */
public class Generate {

	public static void main(String[] args) throws Exception {
		Generate generate = new Generate();
		generate.test();
	}

	public void test() throws Exception {
		TemplateBO templateBO = new TemplateBO();

		// 需要选择性修改的表
		templateBO.setTableName("sys_project");
		templateBO.setTableNameHump("Project"); // 去掉前缀转驼峰，并大写首字母
		templateBO.setTableNameHumpLetter("project"); // 去掉前缀转驼峰，并小写首字母
		templateBO.setTableComment("项目");
		templateBO.setSubPackageName("sys");

		templateBO.setBasePackageName("com.keqi.knife4j");

		String path = "E:/KEQI/code-java/034-knife4j/src/main/java/com/keqi/knife4j/sys";

		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://120.25.26.123:3306/knife4j?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8&allowMultiQueries=true";
		String username = "root";
		String password = "123456";

		//================================读数据库获取表的字段以及注释等信息================================//
		Class.forName(driverClassName);
		Connection connection = DriverManager.getConnection(url, username, password);
		DatabaseMetaData metaData = connection.getMetaData();
		// 从 url 中截取到 DB 名称（示例：jdbc:mysql://10.10.20.200:3306/api-hu?useUnicode=true）
		String dbName = url.substring(url.lastIndexOf('/') + 1, url.indexOf('?'));
		// catalog 参数指的是 DB 名称，如果不指定，则会把 DBMS 中的所有 DB 的所有表都读取出来
		ResultSet tables = metaData.getTables(dbName, null, templateBO.getTableName(), new String[]{"TABLE"});
		// 遍历所有表
		while (tables.next()) {
			ResultSet columns = metaData.getColumns(dbName, null, templateBO.getTableName(), null);
			// 遍历表中的所有字段
			List<ColumnBO> list = new ArrayList<>();
			while (columns.next()) {
				ColumnBO columnBO = new ColumnBO();
				String columnName = columns.getString("COLUMN_NAME"); // 列名称
				columnBO.setColumnName(columnName);
				String columnComment = columns.getString("REMARKS"); // 列描述
				columnBO.setColumnComment(columnComment);
				String columnType = columns.getString("TYPE_NAME").toLowerCase().trim(); // 列类型
				columnBO.setColumnType(columnType);
				list.add(columnBO);
			}
			templateBO.setColumnList(list);
		}
		connection.close();

		//================================构造列对应的数据类型================================//
		for (ColumnBO t : templateBO.getColumnList()) {
			String columnName = t.getColumnName();
			String columnType = t.getColumnType();
			// 根据 columnType 的值获取对应的 javaType 的值
			int i = columnType.indexOf(" ");
			columnType = columnType.substring(0, i == -1 ? columnType.length() : i);
			if ("datetime".equals(columnType)) {
				templateBO.setHasLocalDateTime(true);
			}
			if ("date".equals(columnType)) {
				templateBO.setHasLocalDate(true);
			}
			if ("decimal".equals(columnType) || "float".equals(columnType) || "double".equals(columnType)) {
				templateBO.setHasBigDecimal(true);
			}

			t.setColumnTypeJava(typeMap.get(columnType));
			t.setColumnNameHumpLetter(StrUtil.toCamelCase(columnName));
		}
		Map<String, Object> obj = BeanUtil.beanToMap(templateBO);
		List<Map<String, Object>> columnList = new ArrayList<>();
		for (ColumnBO t : templateBO.getColumnList()) {
			Map<String, Object> temp = BeanUtil.beanToMap(t);
			columnList.add(temp);
		}
		obj.put("columnList", columnList);


		//================================加载ftl模板文件，并生成对应的代码文件================================//
		Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		configuration.setDefaultEncoding("UTF-8");
		configuration.setDirectoryForTemplateLoading(new File(
				ResourceUtils.getURL("classpath:").getPath() + "/ftl"));

		// xxxDO.java
		File doFile = new File(path + "/domain/db", templateBO.getTableNameHump() + "DO.java");
		Template doTemplate = configuration.getTemplate("domain/db/do.ftl");
		doTemplate.process(obj, new FileWriter(doFile));

		// xxxMapper.java
		File mapperFile = new File(path + "/mapper", templateBO.getTableNameHump() + "Mapper.java");
		Template mapperTemplate = configuration.getTemplate("mapper/mapper.ftl");
		mapperTemplate.process(obj, new FileWriter(mapperFile));

		// xxxMapper.xml
		File mapperXMLFile = new File(path + "/mapper", templateBO.getTableNameHump() + "Mapper.xml");
		Template mapperXMLTemplate = configuration.getTemplate("mapper/mapper_xml.ftl");
		mapperXMLTemplate.process(obj, new FileWriter(mapperXMLFile));

		// xxxParam.java
		File paramFile = new File(path + "/domain/param", templateBO.getTableNameHump() + "Param.java");
		Template paramTemplate = configuration.getTemplate("domain/param/param.ftl");
		paramTemplate.process(obj, new FileWriter(paramFile));

		// xxxPageParam.java
		File pageParamFile = new File(path + "/domain/param", templateBO.getTableNameHump() + "PageParam.java");
		Template pageParamTemplate = configuration.getTemplate("domain/param/pageParam.ftl");
		pageParamTemplate.process(obj, new FileWriter(pageParamFile));

		// xxxVO.java
		File voFile = new File(path + "/domain/vo", templateBO.getTableNameHump() + "VO.java");
		Template voTemplate = configuration.getTemplate("domain/vo/vo.ftl");
		voTemplate.process(obj, new FileWriter(voFile));

		// xxxControler.java
		File controllerFile = new File(path + "/controller", templateBO.getTableNameHump() + "Controller.java");
		Template controllerTemplate = configuration.getTemplate("controller/controller.ftl");
		controllerTemplate.process(obj, new FileWriter(controllerFile));

		// xxxService.java
		File serviceFile = new File(path + "/service", templateBO.getTableNameHump() + "Service.java");
		Template serviceTemplate = configuration.getTemplate("service/service.ftl");
		serviceTemplate.process(obj, new FileWriter(serviceFile));

		// xxxServiceImpl.java
		File serviceImplFile = new File(path + "/service/impl", templateBO.getTableNameHump() + "ServiceImpl.java");
		Template serviceImplTemplate = configuration.getTemplate("service/impl/serviceImpl.ftl");
		serviceImplTemplate.process(obj, new FileWriter(serviceImplFile));
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	private static class TemplateBO {

		// 基础包名（eg：com.keqi.knife4j）
		private String basePackageName;

		// 模块包名（eg：sys）
		private String subPackageName;

		// 表名称（eg：sys_account）
		private String tableName;

		// 表注释并去掉最后一个"表"字（eg：用户/角色）
		private String tableComment;

		// 移除掉表名称的前缀的驼峰并大写首字母（eg：Account）
		private String tableNameHump;

		// 移除掉表名称的前缀的驼峰并大写首字母（eg：account）
		private String tableNameHumpLetter;

		// 是否包含了LocalDateTime类型的属性
		private Boolean hasLocalDateTime;

		// 是否包含了LocalDate类型的属性
		private Boolean hasLocalDate;

		// 是否包含了BigDecimal类型的属性
		private Boolean hasBigDecimal;

		// 表中的多个列
		private List<ColumnBO> columnList;

	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	private static class ColumnBO {

		// 列名称（eg：create_time/id）
		private String columnName;

		// 列注释（eg：创建时间/主键）
		private String columnComment;

		// 列类型（eg：datetime/bigint unsigned）
		private String columnType;

		// 列对应的Java类型（eg：LocalDateTime/Long）
		private String columnTypeJava;

		// 列对应的参数名称（eg：createTime/id）
		private String columnNameHumpLetter;
	}

	private static final Map<String, String> typeMap;

	static {
		typeMap = new HashMap<>();
		// 字符串类型
		typeMap.put("char", "String");
		typeMap.put("varchar", "String");
		typeMap.put("text", "String");

		// 数值类型
		typeMap.put("tinyint", "Integer");
		typeMap.put("int", "Integer");
		typeMap.put("bigint", "Long");
		typeMap.put("float", "BigDecimal");
		typeMap.put("double", "BigDecimal");
		typeMap.put("decimal", "BigDecimal");

		// 日期时间类型
		typeMap.put("datetime", "LocalDateTime");
		typeMap.put("date", "LocalDate");
	}
}
