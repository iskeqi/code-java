package com.keqi.springbootmybatiscollection.mapper;
import org.apache.ibatis.annotations.Param;

import com.keqi.springbootmybatiscollection.domain.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    /**
     * 根据 id 找到 Department ，包含了 School
     * @param id id
     * @return r
     */
    Department findOneById(@Param("id")Integer id);


}