package com.keqi.grid.sys.controller;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.MenuPageParam;
import com.keqi.grid.sys.domain.param.MenuParam;
import com.keqi.grid.sys.domain.vo.MenuVO;
import com.keqi.grid.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;

	@PostMapping("/sys/menu")
	public void insert(@Validated @RequestBody MenuParam param) {
		this.menuService.insert(param);
	}

	@PutMapping("/sys/menu")
	public void updateById(@Validated @RequestBody MenuParam param) {
		this.menuService.updateById(param);
	}

	@DeleteMapping("/sys/menu/{id}")
	public void deleteById(@PathVariable Long id) {
		this.menuService.deleteById(id);
	}

	@PostMapping("/sys/menu/page")
	public PageVO<MenuVO> page(@RequestBody MenuPageParam param) {
		return this.menuService.page(param);
	}
}