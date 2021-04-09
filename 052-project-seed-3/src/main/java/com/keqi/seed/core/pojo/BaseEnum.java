package com.keqi.seed.core.pojo;

/**
 * 基础枚举类
 *
 * @author keqi
 */
public interface BaseEnum<T> {

	Integer getCode();

	String getCodeName();

	T buildByCode(Integer code);
}
