package com.keqi.seed.core.pojo;

/**
 * BaseService
 *
 * @author keqi
 */
public interface BaseService<T> {

	void insert(T t);

	void deleteById(Long id);

	void updateById(Long id);

	void getById(Long id);
}
