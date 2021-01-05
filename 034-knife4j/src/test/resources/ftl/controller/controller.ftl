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
import org.springframework.web.bind.annotation.*;

@Api(tags = "${sort}. ${tableComment}管理")
@ApiSupport(order = ${sort})
@AllArgsConstructor
@RestController
public class ${tableNameHump}Controller {

	private final ${tableNameHump}Service ${tableNameHumpLetter}Service;

	@ApiOperation(value = "${sort}.1 新增${tableComment}")
	@ApiOperationSupport(order = 1, ignoreParameters = "${tableNameHumpLetter}Param.id")
	@PostMapping("/sys/${tableNameHumpLetter}/create")
	public void create(@RequestBody ${tableNameHump}Param ${tableNameHumpLetter}Param) {
		this.${tableNameHumpLetter}Service.insert(${tableNameHumpLetter}Param);
	}

	@ApiOperation(value = "${sort}.2 根据ID修改${tableComment}")
	@ApiOperationSupport(order = 2)
	@PostMapping("/sys/${tableNameHumpLetter}/updateById")
	public void updateById(@RequestBody ${tableNameHump}Param ${tableNameHumpLetter}Param) {
		this.${tableNameHumpLetter}Service.updateById(${tableNameHumpLetter}Param);
	}

	@ApiOperation(value = "${sort}.3 根据ID删除${tableComment}")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "${tableComment}ID", example = "1", required = true)
	@PostMapping("/sys/${tableNameHumpLetter}/deleteById")
	public void deleteById(@RequestParam Long id) {
		this.${tableNameHumpLetter}Service.deleteById(id);
	}

	@ApiOperation(value = "${sort}.4 分页查询${tableComment}列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/${tableNameHumpLetter}/page")
	public PageVO<${tableNameHump}VO> page(@RequestBody ${tableNameHump}PageParam pageParam) {
		return this.${tableNameHumpLetter}Service.page(pageParam);
	}
}