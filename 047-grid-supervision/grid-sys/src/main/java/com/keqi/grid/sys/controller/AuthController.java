package com.keqi.grid.sys.controller;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.LoginParam;
import com.keqi.grid.sys.domain.vo.LoginAccountVO;
import com.keqi.grid.sys.domain.vo.LoginVO;
import com.keqi.grid.sys.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/sys/auth")
	public LoginVO login(@Validated @RequestBody LoginParam param) {
		return this.authService.login(param);
	}

	@DeleteMapping("/sys/loginAccount/{id}")
	public void deleteById(@PathVariable Long id) {
		//this.loginAccountService.deleteById(id);
	}

	@GetMapping("/sys/loginAccount")
	public PageVO<LoginAccountVO> page() {
		return null;
	}
}