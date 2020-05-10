package com.keqi.apihu.pj.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class PjDatasourceTableColumnDO implements Serializable {
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

	/**
	 * 数据源ID
	 */
	private Long datasourceId;

	private static final long serialVersionUID = 1L;

	public PjDatasourceTableColumnDO() {
	}

	public PjDatasourceTableColumnDO(String columnName, String columnComment, String columnType) {
		this.columnName = columnName;
		this.columnComment = columnComment;
		this.columnType = columnType;
	}
}