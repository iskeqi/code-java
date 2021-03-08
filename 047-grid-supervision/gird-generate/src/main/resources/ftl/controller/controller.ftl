package ${basePackageName}.${subPackageName}.controller;

import ${basePackageName}.core.pojo.PageVO;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}PageParam;
import ${basePackageName}.${subPackageName}.domain.param.${tableNameHump}Param;
import ${basePackageName}.${subPackageName}.domain.vo.${tableNameHump}VO;
import ${basePackageName}.${subPackageName}.service.${tableNameHump}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ${tableNameHump}Controller {

	@Autowired
	private ${tableNameHump}Service ${tableNameHumpLetter}Service;

	@PostMapping("/sys/${tableNameHumpLetter}")
	public void insert(@Validated @RequestBody ${tableNameHump}Param param) {
		this.${tableNameHumpLetter}Service.insert(param);
	}

	@PutMapping("/sys/${tableNameHumpLetter}")
	public void updateById(@Validated @RequestBody ${tableNameHump}Param param) {
		this.${tableNameHumpLetter}Service.updateById(param);
	}

	@DeleteMapping("/sys/${tableNameHumpLetter}/{id}")
	public void deleteById(@PathVariable Long id) {
		this.${tableNameHumpLetter}Service.deleteById(id);
	}

	@GetMapping("/sys/${tableNameHumpLetter}/page")
	public PageVO<${tableNameHump}VO> page(${tableNameHump}PageParam param) {
		return this.${tableNameHumpLetter}Service.page(param);
	}
}