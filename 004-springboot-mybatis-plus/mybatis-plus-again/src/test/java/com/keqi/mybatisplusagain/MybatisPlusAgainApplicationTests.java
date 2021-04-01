package com.keqi.mybatisplusagain;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.keqi.mybatisplusagain.domain.Account;
import com.keqi.mybatisplusagain.domain.PageParam;
import com.keqi.mybatisplusagain.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusAgainApplicationTests {

	@Autowired
	AccountMapper accountMapper;

	@Test
	void contextLoads() {
		Account account = new Account();
		account.setAccount("keqi");
		account.setPassword("123456");
		account.setNickName("柯琦");
		accountMapper.insert(account);
	}

	@Test
	void contextLoads2() {
		// 使用mp的分页插件需要满足两个条件：
			// 第一个参数必须是 com.baomidou.mybatisplus.extension.plugins.pagination.Page 对象或者它的子类
			// 第二个是，返回值必须是 IPage<T> 类型
		PageParam pageParam = new PageParam();
		pageParam.setCurrent(1);
		pageParam.setSize(1);
		pageParam.setNickName("柯琦");
		IPage<Account> page = accountMapper.page(pageParam);

		System.out.println(page.getTotal());
		System.out.println(page.getRecords().size());
	}

}
