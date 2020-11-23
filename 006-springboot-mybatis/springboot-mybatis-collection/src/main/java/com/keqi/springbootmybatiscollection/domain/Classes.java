package com.keqi.springbootmybatiscollection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
    * 班级表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes {
    /**
    * 班级ID
    */
    private Integer id;

    /**
    * 班级名称
    */
    private String name;

    /**
    * 所属学院ID
    */
    private Integer departmentId;



    private List<Student> studentList;

    private Department department;
}