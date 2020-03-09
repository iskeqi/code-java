package com.keqi.spirngbootdictdb.domain;

import lombok.Data;

@Data
public class DictVO {

	private String valueCode;

	private String valueName;

	private Integer orderNum;

	private String remark;
}
