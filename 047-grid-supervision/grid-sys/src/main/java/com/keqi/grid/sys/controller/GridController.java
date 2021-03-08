package com.keqi.grid.sys.controller;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.GridPageParam;
import com.keqi.grid.sys.domain.param.GridParam;
import com.keqi.grid.sys.domain.vo.GridVO;
import com.keqi.grid.sys.service.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class GridController {

	@Autowired
	private GridService gridService;

	@PostMapping("/sys/grid")
	public void insert(@Validated @RequestBody GridParam param) {
		this.gridService.insert(param);
	}

	@PutMapping("/sys/grid")
	public void updateById(@Validated @RequestBody GridParam param) {
		this.gridService.updateById(param);
	}

	@DeleteMapping("/sys/grid/{id}")
	public void deleteById(@PathVariable Long id) {
		this.gridService.deleteById(id);
	}

	@PostMapping("/sys/grid/page")
	public PageVO<GridVO> page(@RequestBody GridPageParam param) {
		return this.gridService.page(param);
	}
}