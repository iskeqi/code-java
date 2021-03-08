package com.keqi.grid.sys.service;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.AccountPageParam;
import com.keqi.grid.sys.domain.param.AccountParam;
import com.keqi.grid.sys.domain.vo.AccountVO;

public interface AccountService {

	void insert(AccountParam param);

	void updateById(AccountParam param);

	void deleteById(Long id);

	PageVO<AccountVO> page(AccountPageParam param);
}