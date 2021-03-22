package ${basePackageName}.${subPackageName}.service.impl;

import ${basePackageName}.${subPackageName}.entity.${tableNameHump};
import ${basePackageName}.${subPackageName}.dto.${tableNameHump}Dto;
import ${basePackageName}.${subPackageName}.dao.${tableNameHump}Dao;
import ${basePackageName}.${subPackageName}.service.${tableNameHump}Service;
import com.hcttop.ssm.dao.BaseDao;
import com.hcttop.ssm.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ${tableNameHump}ServiceImpl extends AbstractService<${tableNameHump}, ${tableNameHump}Dto> implements ${tableNameHump}Service {

	@Autowired
	private ${tableNameHump}Dao ${tableNameHumpLetter}Dao;

	@Override
	protected BaseDao<${tableNameHump}, ${tableNameHump}Dto> getDao() {
		return this.${tableNameHumpLetter}Dao;
	}
}
