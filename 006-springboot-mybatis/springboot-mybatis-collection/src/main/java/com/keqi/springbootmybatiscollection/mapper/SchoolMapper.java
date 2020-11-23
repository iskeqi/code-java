package com.keqi.springbootmybatiscollection.mapper;

import com.keqi.springbootmybatiscollection.domain.School;

import java.util.List;

public interface SchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);

    /**
     * 查询出 school -> department -> classes -> student
     * @param id id
     * @return r
     */
    School findOneById(Integer id);

    /**
     * 查询出 school -> department -> classes -> student
     * @param id id
     * @return r
     */
    School getById(Integer id);

    /**
     * 查询出 school -> department -> classes -> student
     * @param ids ids
     * @return r
     */
    List<School> getByIds(Integer[] ids);
}