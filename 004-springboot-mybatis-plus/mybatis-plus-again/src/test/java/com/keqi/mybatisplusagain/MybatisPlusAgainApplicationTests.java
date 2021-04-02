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
		account.setNickName("测试 IdType.ASSIGN_ID 类型的主键");

		System.out.println("测试一下这个主键是在创建对象的时候生成的还是执行了 insert 后才生成的：" + account.getId());
		// 果然是执行了 SQL 之后才生成的，其实这才是合理的，创建对象的时候生成反而是错误的，毕竟创建对象又不是一定要插入到数据库中
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

	@Test
	void contextLoads3() {
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

	@Test
	void contextLoads4() {
		// 测试逻辑删除
		Long id = 1377814206023647234L;
		Account account = accountMapper.selectById(id);
		System.out.println(account.getId());
	}

	/*
		MyBatisPlus 提供了很多功能，但是不是每一个都有必要去使用，你需要关注的有以下几个

			1、自动填充（必做）
			2、逻辑删除（推荐）
			3、SQL 打印分析（推荐）
			4、分页插件（必做）
			5、主键生成策略，最好使用雪花算法{IdType.ASSIGN_ID}，而不是数据库自增id

			6、通用枚举、字段类型处理器（不推荐，并没有必要去使用）
			7、数据安全保护（不推荐，没必要这么干）





	 */
}
