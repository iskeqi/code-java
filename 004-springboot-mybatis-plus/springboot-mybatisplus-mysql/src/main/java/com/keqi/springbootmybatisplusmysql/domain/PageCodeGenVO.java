package com.keqi.springbootmybatisplusmysql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageCodeGenVO {

    private Long id;

    private String username;

    private Integer age;
}
