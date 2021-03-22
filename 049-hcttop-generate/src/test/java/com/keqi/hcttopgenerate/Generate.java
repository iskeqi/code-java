package com.keqi.hcttopgenerate;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
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

    @Test
    public void test() throws Exception {
        Generate generate = new Generate();
        List<TemplateBO> list = new ArrayList<>();

        TemplateBO templateBO = new TemplateBO();
        templateBO.setTableName("t_task"); // 表名
        templateBO.setTableNameHump("Task"); // 去掉前缀转驼峰，并大写首字母
        templateBO.setTableNameHumpLetter("task"); // 去掉前缀转驼峰，并小写首字母
        templateBO.setTableComment("任务"); // 表注释并去掉最后的"表"字
        templateBO.setSubPackageName("data"); // 所属子包名
        // 指定生成文件所在的目录
        // String rootPath = System.getProperty("user.dir");
        templateBO.setPath("D:\\hcttop\\data-exchange\\src\\main\\java\\com\\hcttop\\data");

        // 设置是否需要 controller 和 service
        // 2 则需要， 其他值不需要
        templateBO.setType(1);

        templateBO.setBasePackageName("com.hcttop");
        templateBO.setDriverClassName("com.mysql.cj.jdbc.Driver");
        templateBO.setUrl("jdbc:mysql://10.10.20.200:3306/data_exchange_dev?");
        templateBO.setUsername("data_exchange_dev");
        templateBO.setPassword("Hcttop.8888");
        list.add(templateBO);

        for (TemplateBO t : list) {
            generate.test(t);
        }
    }

    /**
     * 生成代码
     *
     * @throws Exception exception
     */
    public void test(TemplateBO templateBO) throws Exception {
        //================================读数据库获取表的字段以及注释等信息================================//
        Class.forName(templateBO.getDriverClassName());
        Connection connection = DriverManager.getConnection(templateBO.getUrl(), templateBO.getUsername(), templateBO.getPassword());
        DatabaseMetaData metaData = connection.getMetaData();
        // 从 url 中截取到 DB 名称（示例：jdbc:mysql://10.10.20.200:3306/api-hu?useUnicode=true）
        String dbName = templateBO.getUrl().substring(templateBO.getUrl().lastIndexOf('/') + 1, templateBO.getUrl().indexOf('?'));
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
            if ("json".equals(columnType)) {
                templateBO.setHasMap(true);
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

        // xxx.java
        File doFile = new File(templateBO.getPath() + "/entity", templateBO.getTableNameHump() + ".java");
        Template doTemplate = configuration.getTemplate("entity/do.ftl");
        doTemplate.process(obj, new FileWriter(doFile));

        // xxxMapper.java
        File mapperFile = new File(templateBO.getPath() + "/mapper", templateBO.getTableNameHump() + "Mapper.java");
        Template mapperTemplate = configuration.getTemplate("mapper/mapper.ftl");
        mapperTemplate.process(obj, new FileWriter(mapperFile));

        // xxxMapper.xml
        File mapperXMLFile = new File(templateBO.getPath() + "/mapper", templateBO.getTableNameHump() + "Mapper.xml");
        Template mapperXMLTemplate = configuration.getTemplate("mapper/mapper_xml.ftl");
        mapperXMLTemplate.process(obj, new FileWriter(mapperXMLFile));

        // xxxDto.java
        File voFile = new File(templateBO.getPath() + "/dto", templateBO.getTableNameHump() + "Dto.java");
        Template voTemplate = configuration.getTemplate("dto/dto.ftl");
        voTemplate.process(obj, new FileWriter(voFile));

        // xxxDao.java
        File daoFile = new File(templateBO.getPath() + "/dao", templateBO.getTableNameHump() + "Dao.java");
        Template daoTemplate = configuration.getTemplate("dao/dao.ftl");
        daoTemplate.process(obj, new FileWriter(daoFile));

        // xxxDaoImpl.java
        File daoImplFile = new File(templateBO.getPath() + "/dao", templateBO.getTableNameHump() + "DaoImpl.java");
        Template daoImplTemplate = configuration.getTemplate("dao/daoImpl.ftl");
        daoImplTemplate.process(obj, new FileWriter(daoImplFile));

        if (templateBO.getType() == 2) {
            // xxxController.java
            File controllerFile = new File(templateBO.getPath() + "/controller", templateBO.getTableNameHump() + "Controller.java");
            Template controllerTemplate = configuration.getTemplate("controller/controller.ftl");
            controllerTemplate.process(obj, new FileWriter(controllerFile));

            // xxxService.java
            File serviceFile = new File(templateBO.getPath() + "/service", templateBO.getTableNameHump() + "Service.java");
            Template serviceTemplate = configuration.getTemplate("service/service.ftl");
            serviceTemplate.process(obj, new FileWriter(serviceFile));

            // xxxServiceImpl.java
            File serviceImplFile = new File(templateBO.getPath() + "/service/impl", templateBO.getTableNameHump() + "ServiceImpl.java");
            Template serviceImplTemplate = configuration.getTemplate("service/impl/serviceImpl.ftl");
            serviceImplTemplate.process(obj, new FileWriter(serviceImplFile));
        }
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

        // 是否包含了json类型的属性
        private Boolean hasMap;

        // 是否需要在Mapper中生成分页信息
        private Boolean pageFlag;

        // 类型
        private Integer type;

        // 驱动名称
        private String driverClassName;

        // 数据库连接URL
        private String url;

        // 用户名
        private String username;

        // 密码
        private String password;

        // path
        private String path;

        // 表中的多个列
        private List<ColumnBO> columnList;

        // controller 在 swagger 中的排序
        private Integer sort;
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
        typeMap.put("bit", "Integer");
        typeMap.put("tinyint", "Integer");
        typeMap.put("int", "Integer");
        typeMap.put("bigint", "Long");
        typeMap.put("float", "BigDecimal");
        typeMap.put("double", "BigDecimal");
        typeMap.put("decimal", "BigDecimal");

        // 日期时间类型
        typeMap.put("datetime", "LocalDateTime");
        typeMap.put("date", "LocalDate");

        // JSON 类型
        typeMap.put("json", "Map<String, Object>");
    }
}
