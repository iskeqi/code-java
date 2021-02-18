package com.keqi.springbootmybatisbase.core;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 不对分页查询方法进行总结，推荐使用 PageHelper 来实现分页
 *
 * @param <DO>
 */
public interface BaseMapper2<DO> {

    int insert(DO t);

    int insertList(@Param("list") List<DO> list);

    int updateById(DO t);

    int update(@Param("t") DO t, @Param("con") DO condition);

    int deleteById(long id);

    int delete(DO condition);

    int deleteByIds(@Param("ids") List<Long> ids);

    DO findById(long id);

    DO find(DO condition);

    List<DO> findByIds(@Param("ids") List<Long> ids);

    List<DO> findList(DO condition);

}
