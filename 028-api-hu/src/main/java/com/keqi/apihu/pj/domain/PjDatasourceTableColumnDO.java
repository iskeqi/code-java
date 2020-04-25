package com.keqi.apihu.pj.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PjDatasourceTableColumnDO {
    private Long id;

    /**
    * 列名
    */
    private String columnName;

    /**
    * 列类型
    */
    private String columnType;

    /**
    * 列描述
    */
    private String columnComment;

    /**
    * 所属表ID
    */
    private Long datasourceTableId;

    public PjDatasourceTableColumnDO(String columnName, String columnComment, String columnType) {
        this.columnName = columnName;
        this.columnComment = columnComment;
        this.columnType = columnType;
    }
}