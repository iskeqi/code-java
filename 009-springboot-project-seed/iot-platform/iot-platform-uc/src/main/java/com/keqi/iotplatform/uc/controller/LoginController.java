package com.keqi.iotplatform.uc.controller;

import com.keqi.iotplatform.core.common.AjaxEntity;
import com.keqi.iotplatform.core.common.AjaxEntityBuilder;
import com.keqi.iotplatform.uc.domain.AuthVO;
import com.keqi.iotplatform.uc.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

	private AuthService authService;

	@PostMapping("/iot-platform/uc/platform/auth")
	public AjaxEntity<AuthVO> auth(String account, String password) {
		return AjaxEntityBuilder.success(authService.auth(account, password));
	}
}
