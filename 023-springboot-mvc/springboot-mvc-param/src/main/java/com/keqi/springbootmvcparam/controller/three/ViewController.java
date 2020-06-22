package com.keqi.springbootmvcparam.controller.three;

import com.keqi.springbootmvcparam.common.AjaxEntity;
import com.keqi.springbootmvcparam.common.AjaxEntityBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring5.webflow.view.AjaxEnabledView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ViewController {

	@GetMapping("/account/list")
	public ModelAndView accountList(String accountName) {
		// 模拟 account 列表查询
		Map<String, Object> accountList = new HashMap<>();
		return new ModelAndView("account", accountList);
	}

	@PostMapping("account/create")
	@ResponseBody
	public AjaxEntity createAccount(String accountName) {
		// 模拟增加 account
		return AjaxEntityBuilder.success();
	}
}
