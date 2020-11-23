package com.keqi.springbootmybatiscollection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 图书馆表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    /**
    * 图书馆ID
    */
    private Integer id;

    /**
    * 图书馆名称
    */
    private String name;

    /**
    * 所属学校ID
    */
    private Integer schoolId;
}