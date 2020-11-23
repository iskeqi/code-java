package com.keqi.springbootmybatiscollection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 学生表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    /**
    * 学生ID
    */
    private Integer id;

    /**
    * 学生名称
    */
    private String name;

    /**
    * 所属班级ID
    */
    private Integer classesId;

    private Classes classes;
}