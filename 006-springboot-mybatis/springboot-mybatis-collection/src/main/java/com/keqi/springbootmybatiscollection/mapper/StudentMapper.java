package com.keqi.springbootmybatiscollection.mapper;
import com.keqi.springbootmybatiscollection.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> findAllByClassesId(@Param("classesId")Integer classesId);

    /**
     * 查询到 student -> classes -> department
     * @param id
     * @return
     */
    Student findOneById(@Param("id")Integer id);

    /**
     * 查询到 student -> classes -> department
     * @param id
     * @return
     */
    Student getById(@Param("id")Integer id);
}