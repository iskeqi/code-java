package com.keqi.seed.sys.domain.db;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author keqi
 */
@Data
public class AccountDO {

	private String name;

	private Integer gender;

	private LocalDate birthday;

	private LocalDateTime createTime;
}
