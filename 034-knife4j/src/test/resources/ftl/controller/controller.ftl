package ${basePackageName}.${subPackageName}.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import ${basePackageName}.core.pojo.PageVO;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}PageParam;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}Param;
import ${basePackageName}.${subPackageName}.domain.vo.${tableNameHump}VO;
import ${basePackageName}.${subPackageName}.service.${tableNameHump}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "${sort}. ${tableComment}管理")
@ApiSupport(order = ${sort})
@AllArgsConstructor
@RestController
public class ${tableNameHump}Controller {

	private final ${tableNameHump}Service ${tableNameHumpLetter}Service;

	@ApiOperation(value = "${sort}.1 新增${tableComment}")
	@ApiOperationSupport(order = 1, ignoreParameters = "param.id")
	@PostMapping("/sys/${tableNameHumpLetter}")
	public void insert(@Validated @RequestBody ${tableNameHump}Param param) {
		this.${tableNameHumpLetter}Service.insert(param);
	}

	@ApiOperation(value = "${sort}.2 修改${tableComment}")
	@ApiOperationSupport(order = 2)
	@PutMapping("/sys/${tableNameHumpLetter}")
	public void updateById(@Validated @RequestBody ${tableNameHump}Param param) {
		this.${tableNameHumpLetter}Service.updateById(param);
	}

	@ApiOperation(value = "${sort}.3 删除${tableComment}")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "${tableComment}ID", example = "1", required = true)
	@DeleteMapping("/sys/${tableNameHumpLetter}/{id}")
	public void deleteById(@PathVariable Long id) {
		this.${tableNameHumpLetter}Service.deleteById(id);
	}

	@ApiOperation(value = "${sort}.4 分页查询${tableComment}列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/${tableNameHumpLetter}/page")
	public PageVO<${tableNameHump}VO> page(@RequestBody ${tableNameHump}PageParam param) {
		return this.${tableNameHumpLetter}Service.page(param);
	}
}