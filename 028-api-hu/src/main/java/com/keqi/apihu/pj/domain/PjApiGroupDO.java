package com.keqi.apihu.pj.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class PjApiGroupDO implements Serializable {
	/**
	 * API分组ID
	 */
	private Long id;

	/**
	 * 父级分组ID
	 */
	private Long parentId;

	/**
	 * 祖级列表
	 */
	private String ancestors;

	/**
	 * 分组名称
	 */
	private String name;

	/**
	 * 显示顺序
	 */
	private Integer orderNum;

	private static final long serialVersionUID = 1L;

	public PjApiGroupDO(Long id) {
		this.id = id;
	}

	//=================其他参数=================//
	private List<PjApiGroupDO> subPjApiGroupDOList = new ArrayList<>();
}