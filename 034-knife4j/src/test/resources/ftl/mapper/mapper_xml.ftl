<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackageName}.${subPackageName}.mapper.${tableNameHump}Mapper">
    <resultMap id="BaseResultMap" type="${basePackageName}.${subPackageName}.domain.db.${tableNameHump}DO">
        <!--@mbg.generated-->
        <!--@Table ${tableName}-->
        <id column="id" property="id"/>
<#list columnList as column>
    <#if column.columnNameHumpLetter != "id">
        <result column="${column.columnName}" property="${column.columnNameHumpLetter}"/>
    </#if>
</#list>
    </resultMap>
</mapper>