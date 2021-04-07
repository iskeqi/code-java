package com.keqi.mybatisplusagain;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.keqi.mybatisplusagain.domain.Account;
import com.keqi.mybatisplusagain.domain.PageParam;
import com.keqi.mybatisplusagain.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

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

		Map<String, Object> map = new HashMap<>();
		map.put("account", account.getAccount());
		map.put("password", account.getPassword());
		account.setJsonStr(map);

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
	void contextLoads4() throws JsonProcessingException {
		// 测试逻辑删除
		Long id = 1377814206023647234L;
		Account account = accountMapper.selectById(id);
		// String jsonStr = account.getJsonStr();
		// 可见 MySQL 中的 json 类型，在 Java 代码里面是可以直接用字符串 String 去接收的
		// 根本就不需要浪费时间去做什么类型转换器，直接使用 String 就行，然后手动的进行对象和字符串之间的转换即可

		// 可见 MySQL 中的 json 类型，在 Java 代码里面直接用 Map<String, Object> 去接收，是不支持的
		// Map<String, Object> jsonStr = account.getJsonStr();

		// 可见 MySQL 中的 json 类型，在 Java 代码里面直接用 Object 去接收是支持的，因为本质上它就是一个字符串
		//Object jsonStr = account.getJsonStr();
		//String s = (String) jsonStr; // 这里能够直接进行强制类型转换，就是最好的证明！！！
		//System.out.println(s);
		//System.out.println(jsonStr);

		//ObjectMapper objectMapper = new ObjectMapper();
		//Map map = objectMapper.readValue(s, Map.class);
		// 利用 jackson 把 json 字符串转换成 Map 对象

		// 以后针对于 MySQL 中的 json 类型，就这么干，这种方式简单又方便
		// 直接使用 Object 类型对应数据库中的 json 类型，而不用 String 是因为，响应 JSON 数据给客户端时，避免字符串的转义

		// 也可以直接使用 Map<String, Object> ,但是需要搭配MP内置的 JacksonTypeHandler 来使用，其实没有必要自己单独写，
		// 因为它已经写过了
		Map<String, Object> map = account.getJsonStr();
		System.out.println(map);


		System.out.println(account.getId());
	}

	/*
		MyBatisPlus 提供了很多功能，但是不是每一个都有必要去使用，你需要关注的有以下几个

			1、自动填充（必做）
			2、逻辑删除（推荐）
			3、SQL 打印分析（推荐）
			4、分页插件（必做）
			5、主键生成策略（必做），最好使用雪花算法{IdType.ASSIGN_ID}，而不是数据库自增id
			6、类型转换器（推荐），尤其是内置的 JacksonTypeHandler 类型转换器，
				完美解决内存中 Map<String, Object> 和 MySQL 中 json 类型之间的转换。根本无需自己编写一个自定义的类型转换器
				如果是 List<Map> 是不支持的，所以，还是使用自定义的类型转换器吧

			7、通用枚举（不推荐，并没有必要去使用）
			8、数据安全保护（不推荐，没必要这么干）





	 */
}
