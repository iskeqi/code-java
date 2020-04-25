package com.keqi.apihu.pj.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PjDatasourceDO {
    private Long id;

    /**
    * 数据源名称
    */
    private String name;

    /**
    * 数据源连接url
    */
    private String url;

    /**
    * 数据源驱动名
    */
    private String driverClassName;

    /**
    * 数据源用户名
    */
    private String username;

    /**
    * 数据源密码
    */
    private String password;
}