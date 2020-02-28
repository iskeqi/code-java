package com.keqi.iotplatform.core.dynamic.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "iot.dynamic.datasource")
@Data
public class DataSourceBO {

  /** 连接池名称，也是数据源的唯一标识 */
  private String pollName;

  private String driverClassName;

  private String url;

  private String username;

  private String password;

  private String urlParam;

}