package com.keqi.grid.generate;

import java.util.List;

public class TemplateBO {

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

    public String getBasePackageName() {
        return basePackageName;
    }

    public void setBasePackageName(String basePackageName) {
        this.basePackageName = basePackageName;
    }

    public String getSubPackageName() {
        return subPackageName;
    }

    public void setSubPackageName(String subPackageName) {
        this.subPackageName = subPackageName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getTableNameHump() {
        return tableNameHump;
    }

    public void setTableNameHump(String tableNameHump) {
        this.tableNameHump = tableNameHump;
    }

    public String getTableNameHumpLetter() {
        return tableNameHumpLetter;
    }

    public void setTableNameHumpLetter(String tableNameHumpLetter) {
        this.tableNameHumpLetter = tableNameHumpLetter;
    }

    public Boolean getHasLocalDateTime() {
        return hasLocalDateTime;
    }

    public void setHasLocalDateTime(Boolean hasLocalDateTime) {
        this.hasLocalDateTime = hasLocalDateTime;
    }

    public Boolean getHasLocalDate() {
        return hasLocalDate;
    }

    public void setHasLocalDate(Boolean hasLocalDate) {
        this.hasLocalDate = hasLocalDate;
    }

    public Boolean getHasBigDecimal() {
        return hasBigDecimal;
    }

    public void setHasBigDecimal(Boolean hasBigDecimal) {
        this.hasBigDecimal = hasBigDecimal;
    }

    public Boolean getHasMap() {
        return hasMap;
    }

    public void setHasMap(Boolean hasMap) {
        this.hasMap = hasMap;
    }

    public Boolean getPageFlag() {
        return pageFlag;
    }

    public void setPageFlag(Boolean pageFlag) {
        this.pageFlag = pageFlag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ColumnBO> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnBO> columnList) {
        this.columnList = columnList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
