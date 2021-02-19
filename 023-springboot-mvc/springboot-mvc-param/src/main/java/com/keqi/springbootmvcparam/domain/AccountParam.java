package com.keqi.springbootmvcparam.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户参数(新增/修改公用此Param类)
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountParam {

	// 新增时此参数无效，修改时必传
	private Long id;

	private String account;

	// 此参数可选(前端可能传递的是""或者是null)
	private String remark;

	// JSON 字符串
	private String jsonStr;

	// 测试 BigDecimal 类
	private BigDecimal longitude;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime localDateTime;

	// 测试Boolean类型
	private Boolean success;

	// 测试 mqtt 规则引擎桥接数据到 web 服务
	private String username;

	private String clientid;
}
