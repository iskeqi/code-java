package com.keqi.grid.generate;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
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
        templateBO.setTableName("sys_login_account"); // 表名
        templateBO.setTableNameHump("LoginAccount"); // 去掉前缀转驼峰，并大写首字母
        templateBO.setTableNameHumpLetter("loginAccount"); // 去掉前缀转驼峰，并小写首字母
        templateBO.setTableComment("登录用户"); // 表注释并去掉最后的"表"字
        templateBO.setSubPackageName("sys"); // 所属子包名
        // 指定生成文件所在的目录
        // String rootPath = System.getProperty("user.dir");
        templateBO.setPath("E:\\KEQI\\code-java\\047-grid-supervision\\grid-sys\\src\\main\\java\\com\\keqi\\grid\\sys");
        // controller 在 swagger 中的排序
        // templateBO.setSort(8);

        templateBO.setBasePackageName("com.keqi.grid");
        templateBO.setDriverClassName("com.mysql.cj.jdbc.Driver");
        templateBO.setUrl("jdbc:mysql://rm-bp1f65ehm719kd63y5o.mysql.rds.aliyuncs.com:3306/047-grid-supervision?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8&allowMultiQueries=true");
        templateBO.setUsername("keqi");
        templateBO.setPassword("Aliyun_rds_123456");
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
                ResourceUtils.getURL("E:\\KEQI\\code-java\\047-grid-supervision\\gird-generate\\src\\main\\resources").getPath() + "/ftl"));

        // xxxDO.java
        File doFile = new File(templateBO.getPath() + "/domain/db", templateBO.getTableNameHump() + "DO.java");
        Template doTemplate = configuration.getTemplate("domain/db/do.ftl");
        doTemplate.process(obj, new FileWriter(doFile));

        // xxxMapper.java
        File mapperFile = new File(templateBO.getPath() + "/mapper", templateBO.getTableNameHump() + "Mapper.java");
        Template mapperTemplate = configuration.getTemplate("mapper/mapper.ftl");
        mapperTemplate.process(obj, new FileWriter(mapperFile));

        // xxxMapper.xml
        File mapperXMLFile = new File(templateBO.getPath() + "/mapper", templateBO.getTableNameHump() + "Mapper.xml");
        Template mapperXMLTemplate = configuration.getTemplate("mapper/mapper_xml.ftl");
        mapperXMLTemplate.process(obj, new FileWriter(mapperXMLFile));

        // xxxVO.java
        File voFile = new File(templateBO.getPath() + "/domain/vo", templateBO.getTableNameHump() + "VO.java");
        Template voTemplate = configuration.getTemplate("domain/vo/vo.ftl");
        voTemplate.process(obj, new FileWriter(voFile));

        // xxxPageParam.java
        File pageParamFile = new File(templateBO.getPath() + "/domain/param", templateBO.getTableNameHump() + "PageParam.java");
        Template pageParamTemplate = configuration.getTemplate("domain/param/pageParam.ftl");
        pageParamTemplate.process(obj, new FileWriter(pageParamFile));

        // xxxParam.java
        File paramFile = new File(templateBO.getPath() + "/domain/param", templateBO.getTableNameHump() + "Param.java");
        Template paramTemplate = configuration.getTemplate("domain/param/param.ftl");
        paramTemplate.process(obj, new FileWriter(paramFile));

        // xxxControler.java
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
