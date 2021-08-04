package com.keqi.seed.core.pojo;

/**
 * BaseService
 *
 * @author keqi
 */
public interface BaseService<T> {

	T insert(T t);

	int deleteById(Long id);

	int updateById(Long id);

	T getById(Long id);
}
