package com.keqi.seed.core.pojo;

/**
 * BaseService
 *
 * @author keqi
 */
public interface BaseService<T> {

	T insert(T t);

	int deleteById(String id);

	int updateById(T t);

	T getById(String id);
}
