package com.keqi.apihu.manage.service;

import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.manage.domain.AccountDO;
import com.keqi.apihu.manage.domain.AccountListParam;
import com.keqi.apihu.manage.domain.LoginVO;

import java.util.List;
public interface AccountService {


    int deleteByPrimaryKey(Long id);

    int insert(AccountDO record);

    int insertOrUpdate(AccountDO record);

    int insertOrUpdateSelective(AccountDO record);

    int insertSelective(AccountDO record);

    AccountDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountDO record);

    int updateByPrimaryKey(AccountDO record);

    int updateBatch(List<AccountDO> list);

    int updateBatchSelective(List<AccountDO> list);

    int batchInsert(List<AccountDO> list);

    /**
     * 创建用户
     * @param accountDO accountDO
     */
    void createAccount(AccountDO accountDO);

    /**
     * 根据用户id删除用户
     * @param id
     */
	void deleteAccountById(Long id);

    /**
     * 根据用户ID修改用户信息
     * @param accountDO accountDO
     */
    void updateAccountById(AccountDO accountDO);

    /**
     * 查询用户列表
     * @param accountListParam accountListParam
     * @return r
     */
	PageVO listAccount(AccountListParam accountListParam);

    /**
     * 批量删除用户
     * @param ids ids
     */
    void deleteAccountByIds(Long[] ids);

    /**
     * 登录
     * @param account account
     * @param password password
     * @return r
     */
    LoginVO login(String account, String password);
}
