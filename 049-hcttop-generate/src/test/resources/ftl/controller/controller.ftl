package ${basePackageName}.${subPackageName}.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import ${basePackageName}.${subPackageName}.entity.${tableNameHump};
import ${basePackageName}.${subPackageName}.dto.${tableNameHump}Dto;
import ${basePackageName}.${subPackageName}.service.${tableNameHump}Service;
import com.hcttop.ssm.common.BaseController;
import com.hcttop.ssm.common.PageData;
import com.hcttop.ssm.common.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "${tableComment}管理")
@RequestMapping("/api/task")
@RestController
public class ${tableNameHump}Controller extends BaseController {

	@Autowired
	private ${tableNameHump}Service ${tableNameHumpLetter}Service;

	@ApiOperation(value = "新增${tableComment}")
	@ApiOperationSupport(order = 1, ignoreParameters = "param.id")
	@PostMapping("/sys/${tableNameHumpLetter}")
	public void insert(@RequestBody ${tableNameHump} param) {
		this.${tableNameHumpLetter}Service.insert(param);
	}

	@ApiOperation(value = "删除${tableComment}")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "${tableComment}ID", example = "1", required = true)
	@DeleteMapping("/sys/${tableNameHumpLetter}/{id}")
	public void removeById(@PathVariable Long id) {
		this.${tableNameHumpLetter}Service.removeById(id);
	}

	@ApiOperation(value = "修改${tableComment}")
	@ApiOperationSupport(order = 2)
	@PutMapping("/sys/${tableNameHumpLetter}")
	public void update(@Validated @RequestBody ${tableNameHump} param) {
		this.${tableNameHumpLetter}Service.update(param);
	}

	@ApiOperation(value = "分页查询${tableComment}列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/${tableNameHumpLetter}/pageQuery")
	public PageData<${tableNameHump}Dto> pageQuery(PageRequest pageRequest) {
		${tableNameHump}Dto ${tableNameHumpLetter}Dto = new ${tableNameHump}Dto();
		// BeanUtil.copyProperties(param, ${tableNameHumpLetter}Dto);

		PageData<${tableNameHump}Dto> pageData = new PageData<>(pageRequest, ${tableNameHumpLetter}Dto);

		return this.${tableNameHumpLetter}Service.pageQuery(pageData);
	}
}