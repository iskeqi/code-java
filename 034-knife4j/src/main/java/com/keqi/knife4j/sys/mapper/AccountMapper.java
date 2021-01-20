package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.knife4j.sys.domain.db.AccountDO;
import com.keqi.knife4j.sys.domain.param.AccountPageParam;
import com.keqi.knife4j.sys.domain.vo.AccountVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper extends BaseMapper<AccountDO> {

	/**
	 * 根据用户名查询用户信息
	 *
	 * @param account account
	 * @return r
	 */
	AccountDO getByAccount(@Param("account") String account);

	/**
	 * 根据id修改密码
	 *
	 * @param newPassword newPassword
	 * @param id          id
	 * @return r
	 */
	int updatePasswordById(@Param("newPassword") String newPassword, @Param("id") Long id);

	/**
	 * 分页查询用户列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	List<AccountVO> page(AccountPageParam pageParam);
}