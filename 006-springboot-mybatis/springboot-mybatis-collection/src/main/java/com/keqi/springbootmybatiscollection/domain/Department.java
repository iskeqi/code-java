package com.keqi.springbootmybatiscollection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
    * 学院表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    /**
    * 学院ID
    */
    private Integer id;

    /**
    * 学院名称
    */
    private String name;

    /**
    * 所属学校ID
    */
    private Integer schoolId;

    private List<Classes> classesList;

    private School school;
}