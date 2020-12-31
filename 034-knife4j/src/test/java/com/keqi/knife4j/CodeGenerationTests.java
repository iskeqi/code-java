package com.keqi.knife4j;

import cn.hutool.core.util.StrUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用 FreeMarker 模板技术生成代码
 *
 * @author keqi
 */
public class CodeGenerationTests {

	private static final String TABLE_COMMENT = "tableComment";
	private static final String COLUMN_NAME = "columnName";
	private static final String COLUMN_NAME_HUMP = "columnNameHump";
	private static final String COLUMN_COMMENT = "columnComment";
	private static final String COLUMN_TYPE = "columnType";
	private static final String COLUMN_TYPE_JAVA = "columnTypeJava";
	private static final String COLUMN_LIST = "columnList";
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

	@Test
	void contextLoads() throws Exception {
		// 每次生成新的代码是需要更改的
		String tableName = "sys_account";

		// 移除掉表名称的前缀并大写首字母
		String tableNameHump = StrUtil.upperFirst(StrUtil.removePrefix(tableName, "sys_"));
		// 移除掉表名称的前缀
		String tableNameHumpLetter = StrUtil.removePrefix(tableName, "sys_");

		String tableComment = "用户";

		String basePackageName = "com.keqi.knife4j";
		String suffix = "sys";
		String packageName = basePackageName + "." + suffix;


		String path = "E:/KEQI/code-java/034-knife4j/src/main/java/com/keqi/knife4j/sys";

		generate(tableName, tableNameHump, tableComment, tableNameHumpLetter,
				basePackageName, packageName,
				path);
	}

	/**
	 * 根据指定的 4 个配置生成代码
	 *
	 * @param tableName           tableName
	 * @param tableNameHump       tableNameHump
	 * @param tableComment        tableComment
	 * @param tableNameHumpLetter tableNameHumpLetter
	 * @param basePackageName     basePackageName
	 * @param packageName         packageName
	 * @param path                path
	 * @throws Exception exception
	 */
	private void generate(String tableName, String tableNameHump, String tableComment, String tableNameHumpLetter,
	                      String basePackageName, String packageName,
	                      String path) throws Exception {
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://120.25.26.123:3306/knife4j?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8&allowMultiQueries=true";
		String username = "root";
		String password = "123456";
		// 连接数据库，并获取表结构的信息
		Map<String, Object> tableInfo = this.getTableInfo(driverClassName, url, username, password, tableName);
		List<Map<String, String>> columnList = (List<Map<String, String>>) tableInfo.get(COLUMN_LIST);

		// 组装数据
		Map<String, Object> obj = new HashMap<>();
		obj.put("packageName", packageName);
		obj.put("basePackageName", basePackageName);
		obj.put("tableNameHumpLetter", tableNameHumpLetter);
		obj.put("tableComment", tableComment);
		obj.put("tableNameHump", tableNameHump);
		obj.put("tableName", tableName);
		for (Map<String, String> t : columnList) {
			String columnName = t.get(COLUMN_NAME);
			String columnType = t.get(COLUMN_TYPE);
			t.put(COLUMN_NAME_HUMP, StrUtil.toCamelCase(columnName));

			// 根据 columnType 的值获取对应的 javaType 的值
			int i = columnType.indexOf(" ");
			columnType = columnType.substring(0, i == -1 ? columnType.length() : i);
			if ("datetime".equals(columnType)) {
				obj.put("hasLocalDateTime", "datetime");
			}
			if ("date".equals(columnType)) {
				obj.put("hasLocalDate", "date");
			}
			if ("decimal".equals(columnType) || "float".equals(columnType) || "double".equals(columnType)) {
				obj.put("hasBigDecimal", "decimal");
			}

			t.put(COLUMN_TYPE_JAVA, typeMap.get(columnType));
		}
		obj.put("columnList", columnList);

		Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		configuration.setDefaultEncoding("UTF-8");
		configuration.setDirectoryForTemplateLoading(new File(
				ResourceUtils.getURL("classpath:").getPath() + "/ftl"));

		// xxxParam.java
		File paramFile = new File(path + "/domain/param", tableNameHump + "Param.java");
		Template paramTemplate = configuration.getTemplate("param.ftl");
		paramTemplate.process(obj, new FileWriter(paramFile));

		// xxxPageParam.java
		File pageParamFile = new File(path + "/domain/param", tableNameHump + "PageParam.java");
		Template pageParamTemplate = configuration.getTemplate("pageParam.ftl");
		pageParamTemplate.process(obj, new FileWriter(pageParamFile));

		// xxxVO.java
		File voFile = new File(path + "/domain/vo", tableNameHump + "VO.java");
		Template voTemplate = configuration.getTemplate("vo.ftl");
		voTemplate.process(obj, new FileWriter(voFile));

		// xxxDO.java
		File doFile = new File(path + "/domain/db", tableNameHump + "DO.java");
		Template doTemplate = configuration.getTemplate("do.ftl");
		doTemplate.process(obj, new FileWriter(doFile));

		// xxxService.java
		File serviceFile = new File(path + "/service", tableNameHump + "Service.java");
		Template serviceTemplate = configuration.getTemplate("service.ftl");
		serviceTemplate.process(obj, new FileWriter(serviceFile));

		// xxxServiceImpl.java
		File serviceImplFile = new File(path + "/service/impl", tableNameHump + "ServiceImpl.java");
		Template serviceImplTemplate = configuration.getTemplate("serviceImpl.ftl");
		serviceImplTemplate.process(obj, new FileWriter(serviceImplFile));

		// xxxMapper.java
		File mapperFile = new File(path + "/mapper", tableNameHump + "Mapper.java");
		Template mapperTemplate = configuration.getTemplate("mapper.ftl");
		mapperTemplate.process(obj, new FileWriter(mapperFile));

		// xxxMapper.xml
		File mapperXMLFile = new File(path + "/mapper", tableNameHump + "Mapper.xml");
		Template mapperXMLTemplate = configuration.getTemplate("mapper_xml.ftl");
		mapperXMLTemplate.process(obj, new FileWriter(mapperXMLFile));

		// xxxControler.java
		File controllerFile = new File(path + "/controller", tableNameHump + "Controller.java");
		Template controllerTemplate = configuration.getTemplate("controller.ftl");
		controllerTemplate.process(obj, new FileWriter(controllerFile));
	}

	/**
	 * 获取指定数据库下指定表的信息
	 *
	 * @param driverClassName driverClassName
	 * @param url             url
	 * @param username        username
	 * @param password        password
	 * @param tableName       tableName
	 * @return r
	 * @throws Exception e
	 */
	private Map<String, Object> getTableInfo(String driverClassName, String url, String username, String password, String tableName) throws Exception {
		Map<String, Object> result = new HashMap<>();

		// 加载驱动&创建连接
		Class.forName(driverClassName);
		Connection connection = DriverManager.getConnection(url, username, password);

		// 获取元数据信息
		DatabaseMetaData metaData = connection.getMetaData();

		// 从 url 中截取到 DB 名称（示例：jdbc:mysql://10.10.20.200:3306/api-hu?useUnicode=true）
		String dbName = url.substring(url.lastIndexOf('/') + 1, url.indexOf('?'));

		// catalog 参数指的是 DB 名称，如果不指定，则会把 DBMS 中的所有 DB 的所有表都读取出来
		ResultSet tables = metaData.getTables(dbName, null, tableName, new String[]{"TABLE"});
		// 遍历所有表
		while (tables.next()) {
			String tableComment = tables.getString("REMARKS");
			result.put(TABLE_COMMENT, tableComment);
			ResultSet columns = metaData.getColumns(dbName, null, tableName, null);

			// 遍历表中的所有字段
			List<Map<String, String>> list = new ArrayList<>();
			while (columns.next()) {
				Map<String, String> columnMap = new HashMap<>();

				String columnName = columns.getString("COLUMN_NAME"); // 列名称
				columnMap.put(COLUMN_NAME, columnName);
				String columnComment = columns.getString("REMARKS"); // 列描述
				columnMap.put(COLUMN_COMMENT, columnComment);
				String columnType = columns.getString("TYPE_NAME").toLowerCase().trim(); // 列类型
				columnMap.put(COLUMN_TYPE, columnType);

				list.add(columnMap);
			}
			result.put(COLUMN_LIST, list);
		}
		connection.close();
		return result;
	}
}
