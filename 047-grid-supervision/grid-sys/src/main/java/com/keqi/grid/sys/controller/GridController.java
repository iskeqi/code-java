package com.keqi.grid.sys.controller;

import com.keqi.grid.sys.domain.vo.GridVO;
import com.keqi.grid.sys.service.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GridController {

	@Autowired
	private GridService gridService;

	@GetMapping("/sys/grid")
	public List<GridVO> findAll() {
		return this.gridService.findTreeAll();
	}
}