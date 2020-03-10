package com.keqi.spirngbootdictdb.mapper;

import com.keqi.spirngbootdictdb.domain.Account;
import com.keqi.spirngbootdictdb.domain.AccountEnum;

public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    AccountEnum selectAccountEnumByPrimaryKey(Long id);
}