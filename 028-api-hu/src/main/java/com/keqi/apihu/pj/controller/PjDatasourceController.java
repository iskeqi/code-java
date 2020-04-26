package com.keqi.apihu.pj.controller;

import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.pj.domain.PjDatasourceDO;
import com.keqi.apihu.pj.service.PjDatasourceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据源管理
 */
@RestController
@AllArgsConstructor
public class PjDatasourceController {

	private final PjDatasourceService pjDatasourceService;

	@PostMapping("/datasource/create")
	public AjaxEntity create(@RequestBody PjDatasourceDO pjDatasourceDO) {
		this.pjDatasourceService.create(pjDatasourceDO);
		return AjaxEntityBuilder.success();
	}

	@PostMapping("/datasource/delete")
	public AjaxEntity delete(Long datasourceId) {
		this.pjDatasourceService.deleteByDatasourceId(datasourceId);
		return AjaxEntityBuilder.success();
	}












	@GetMapping("/datasource/readDatasource")
	public AjaxEntity readDataSource(Long datasourceId) {
		pjDatasourceService.readDataSource(datasourceId);
		return AjaxEntityBuilder.success();
	}

}
