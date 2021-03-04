package com.keqi.grid.generate;

public class ColumnBO {

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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnTypeJava() {
        return columnTypeJava;
    }

    public void setColumnTypeJava(String columnTypeJava) {
        this.columnTypeJava = columnTypeJava;
    }

    public String getColumnNameHumpLetter() {
        return columnNameHumpLetter;
    }

    public void setColumnNameHumpLetter(String columnNameHumpLetter) {
        this.columnNameHumpLetter = columnNameHumpLetter;
    }
}
