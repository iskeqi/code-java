package com.keqi.iotplatform.core.domain;

import lombok.Data;

@Data
public class DataSourceBO {

  /** 连接池名称，也是数据源的唯一标识 */
  private String pollName;

  private String driverClassName;

  private String url;

  private String username;

  private String password;

}
