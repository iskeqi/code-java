package com.keqi.grid.sys.controller;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.DictItemPageParam;
import com.keqi.grid.sys.domain.param.DictItemParam;
import com.keqi.grid.sys.domain.vo.DictItemVO;
import com.keqi.grid.sys.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class DictItemController {

	@Autowired
	private DictItemService dictItemService;

	@PostMapping("/sys/dictItem")
	public void insert(@Validated @RequestBody DictItemParam param) {
		this.dictItemService.insert(param);
	}

	@PutMapping("/sys/dictItem")
	public void updateById(@Validated @RequestBody DictItemParam param) {
		this.dictItemService.updateById(param);
	}

	@DeleteMapping("/sys/dictItem/{id}")
	public void deleteById(@PathVariable Long id) {
		this.dictItemService.deleteById(id);
	}

	@PostMapping("/sys/dictItem/page")
	public PageVO<DictItemVO> page(@RequestBody DictItemPageParam param) {
		return this.dictItemService.page(param);
	}
}