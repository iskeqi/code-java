package com.keqi.apihu.pj.controller;

import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.pj.domain.PjApiGroupDO;
import com.keqi.apihu.pj.service.PjApiGroupService;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PjApiGroupController {

	private final PjApiGroupService pjApiGroupService;

	@PostMapping("/apiGroup/create")
	public AjaxEntity create(@RequestBody PjApiGroupDO pjApiGroupDO) {
		this.pjApiGroupService.create(pjApiGroupDO);
		return AjaxEntityBuilder.success();
	}

	@PostMapping("/apiGroup/delete")
	public AjaxEntity delete(@Param("id") Long apiGroupId) {
		this.pjApiGroupService.deleteByPrimaryKey(apiGroupId);
		return AjaxEntityBuilder.success();
	}

	@PostMapping("/apiGroup/update")
	public AjaxEntity update(@RequestBody PjApiGroupDO pjApiGroupDO) {
		this.pjApiGroupService.updateNameByPrimaryKey(pjApiGroupDO);
		return AjaxEntityBuilder.success();
	}

	@GetMapping("/apiGroup/list")
	public AjaxEntity list() {
		return AjaxEntityBuilder.success(this.pjApiGroupService.list());
	}

	@PostMapping("/apiGroup/moveGroupOrder")
	public AjaxEntity moveGroupOrder(@RequestBody List<PjApiGroupDO> pjApiGroupDOList) {
		this.pjApiGroupService.moveGroupOrder(pjApiGroupDOList);
		return AjaxEntityBuilder.success();
	}
}
