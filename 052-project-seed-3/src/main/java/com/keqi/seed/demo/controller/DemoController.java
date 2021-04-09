package com.keqi.seed.demo.controller;

import com.keqi.seed.demo.domain.db.Account;
import com.keqi.seed.demo.execption.DemoException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController
 *
 * @author keqi
 */
@RestController
public class DemoController {

	@PostMapping("/test1")
	public Account test1(@RequestBody Account account) {
		return account;
	}

	@PostMapping("/test2")
	public Account test2(Account account) {
		return account;
	}

	@PostMapping("/test3")
	public void test3() {
		throw new DemoException();
	}
}
