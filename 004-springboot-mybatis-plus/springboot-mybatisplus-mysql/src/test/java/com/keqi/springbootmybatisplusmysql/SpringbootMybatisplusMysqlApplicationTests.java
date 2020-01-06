package com.keqi.springbootmybatisplusmysql;

import com.keqi.springbootmybatisplusmysql.domain.CodeGenDO;
import com.keqi.springbootmybatisplusmysql.mapper.CodeGenMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisplusMysqlApplicationTests {

	@Autowired
	CodeGenMapper codeGenMapper;

	@Test
	void contextLoads() {

		CodeGenDO keqi = codeGenMapper.selectByUsername("keqi");
		System.out.println(keqi);


		List<CodeGenDO> codeGenDOS = codeGenMapper.selectList(null);
		codeGenDOS.forEach(x -> System.out.println(x));
	}

}
