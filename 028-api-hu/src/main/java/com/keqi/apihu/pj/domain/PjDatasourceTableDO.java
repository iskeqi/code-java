package com.keqi.apihu.pj.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PjDatasourceTableDO {
    private Long id;

    /**
    * 数据源ID
    */
    private Long datasourceId;

    /**
    * 表名称
    */
    private String tableName;

    /**
    * 表备注
    */
    private String tableComment;

    public PjDatasourceTableDO(String tableName, String tableComment) {
        this.tableName = tableName;
        this.tableComment = tableComment;
    }

    //=============其它参数============//

    private List<PjDatasourceTableColumnDO> datasourceTableColumnDOList;
}