package com.keqi.springbootmybatiscollection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
    * 学校表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    /**
    * 学校ID
    */
    private Integer id;

    /**
    * 学校名称
    */
    private String name;

    private List<Department> departmentList;

    private List<Library> libraries;
}