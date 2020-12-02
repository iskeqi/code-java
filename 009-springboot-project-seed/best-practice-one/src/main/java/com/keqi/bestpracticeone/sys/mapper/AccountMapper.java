package com.keqi.bestpracticeone.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.bestpracticeone.sys.domain.db.AccountDO;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper extends BaseMapper<AccountDO> {

    /**
     * 根据用户名查询用户信息
     *
     * @param account account
     * @return r
     */
    AccountDO getByAccount(@Param("account") String account);


}