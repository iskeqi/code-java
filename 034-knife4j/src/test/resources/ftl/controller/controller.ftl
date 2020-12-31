package ${packageName}.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.core.pojo.PageVO;
import ${packageName}.domain.param.${tableNameHump}PageParam;
import ${packageName}.domain.param.${tableNameHump}Param;
import ${packageName}.domain.vo.${tableNameHump}VO;
import ${packageName}.service.${tableNameHump}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = "1. ${tableComment}管理")
@ApiSupport(order = 1)
@AllArgsConstructor
@RestController
public class ${tableNameHump}Controller {

	private final ${tableNameHump}Service ${tableNameHumpLetter}Service;

	@ApiOperation(value = "1.1 新增${tableComment}")
	@ApiOperationSupport(order = 1, ignoreParameters = "${tableNameHumpLetter}Param.id")
	@PostMapping("/sys/${tableNameHumpLetter}/create")
	public void create(@RequestBody ${tableNameHump}Param ${tableNameHumpLetter}Param) {

	}

	@ApiOperation(value = "1.2 根据ID修改${tableComment}")
	@ApiOperationSupport(order = 2)
	@PostMapping("/sys/${tableNameHumpLetter}/updateById")
	public void updateById(@RequestBody ${tableNameHump}Param ${tableNameHumpLetter}Param) {

	}

	@ApiOperation(value = "1.3 根据ID删除${tableComment}")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "${tableComment}ID", example = "1", required = true)
	@PostMapping("/sys/${tableNameHumpLetter}/deleteById")
	public void deleteById(@RequestParam Long id) {

	}

	@ApiOperation(value = "1.4 分页查询${tableComment}列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/${tableNameHumpLetter}/page")
	public PageVO<${tableNameHump}VO> page(@RequestBody ${tableNameHump}PageParam pageParam) {
		return null;
	}
}