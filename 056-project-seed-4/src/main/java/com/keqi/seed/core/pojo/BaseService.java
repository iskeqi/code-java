package com.keqi.seed.core.pojo;

/**
 * BaseService
 *
 * @author keqi
 */
public interface BaseService<T> {

	T insert(T t);

	void deleteById(String id);

	void updateById(T t);

	T getById(String id);
}
