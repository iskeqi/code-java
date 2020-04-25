package com.keqi.apihu.pj.controller;

import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.pj.service.PjDatasourceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据源管理
 */
@RestController
@AllArgsConstructor
public class PjDatasourceController {

	private final PjDatasourceService pjDatasourceService;

	@GetMapping("/datasource/readDatasource")
	public AjaxEntity readDataSource(Long datasourceId) {
		pjDatasourceService.readDataSource(datasourceId);
		return AjaxEntityBuilder.success();
	}

}
