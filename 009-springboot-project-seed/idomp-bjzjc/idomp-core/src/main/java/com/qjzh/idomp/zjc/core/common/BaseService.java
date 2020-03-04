package com.qjzh.idomp.zjc.core.common;

import java.util.List;

/**
 * 基础Service接口
 *
 * 该接口中的方法作用仅仅是规范命名，不强制要求实现(规范命名的同时，给予充分自由)
 *
 * @author keqi
 */
public interface BaseService<T> {

    /**
     * 插入一条记录
     * @param entity entity
     */
    default void insert(T entity) {}

    /**
     * 批量插入记录
     * @param entityList entityList
     */
    default void insertBatch(List<T> entityList) {}

    /**
     * 删除一条记录
     * @param entity entity
     */
    default void deleteById(T entity) {}

    /**
     * 批量删除多条记录
     * @param entity entity
     */
    default void deleteByIds(T entity) {}

    /**
     * 修改记录
     * @param entity entity
     */
    default void updateById(T entity) {}

    /**
     * 查询单个记录
     * @param entity entity
     * @return r
     */
    default T getById(T entity) {
        return null;
    }

    /**
     * 查询记录总数
     * @param entity entity
     * @return r
     */
    default Long count(T entity) {
        return null;
    }

    /**
     * 查询记录列表
     * @param entity entity
     * @return r
     */
    default List<?> list(T entity) {
        return null;
    }


}
