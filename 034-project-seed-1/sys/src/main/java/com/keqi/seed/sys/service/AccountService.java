package com.keqi.seed.sys.service;

import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.param.AccountCreateParam;
import com.keqi.seed.sys.domain.param.AccountPageParam;
import com.keqi.seed.sys.domain.param.AccountUpdateParam;
import com.keqi.seed.sys.domain.vo.AccountVO;

public interface AccountService {

    void insert(AccountCreateParam param);

    void updateById(AccountUpdateParam param);

    void deleteById(Long id);

    PageVO<AccountVO> page(AccountPageParam param);
}
