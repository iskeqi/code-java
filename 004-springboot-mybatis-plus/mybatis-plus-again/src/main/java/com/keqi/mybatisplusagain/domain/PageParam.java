package com.keqi.mybatisplusagain.domain;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageParam extends Page<Account> {

	private static final long serialVersionUID = -5855729062044865953L;
	protected String nickName;
}
