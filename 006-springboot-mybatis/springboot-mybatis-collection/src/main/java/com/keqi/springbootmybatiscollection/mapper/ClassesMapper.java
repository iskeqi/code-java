package com.keqi.springbootmybatiscollection.mapper;
import com.keqi.springbootmybatiscollection.domain.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    /**
     * 根据 departmentId 查找 Classes 列表，并封装了 Student 列表
     * @param departmentId departmentId
     * @return r
     */
    List<Classes> findAllByDepartmentId(@Param("departmentId")Integer departmentId);


}