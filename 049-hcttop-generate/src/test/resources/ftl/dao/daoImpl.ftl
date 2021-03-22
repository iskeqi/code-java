package ${basePackageName}.${subPackageName}.dao;

import ${basePackageName}.${subPackageName}.dto.${tableNameHump}Dto;
import ${basePackageName}.${subPackageName}.entity.${tableNameHump};
import ${basePackageName}.${subPackageName}.mapper.${tableNameHump}Mapper;
import com.hcttop.ssm.dao.AbstractDao;
import com.hcttop.ssm.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ${tableNameHump}DaoImpl extends AbstractDao<${tableNameHump}, ${tableNameHump}Dto> implements ${tableNameHump}Dao {

    @Autowired
    private ${tableNameHump}Mapper ${tableNameHumpLetter}Mapper;

    @Override
    protected BaseMapper<${tableNameHump}, ${tableNameHump}Dto> getMapper() {
        return this.${tableNameHumpLetter}Mapper;
    }
}