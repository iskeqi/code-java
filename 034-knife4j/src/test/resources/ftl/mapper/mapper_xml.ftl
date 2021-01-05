<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackageName}.${subPackageName}.mapper.${tableNameHump}Mapper">
    <resultMap id="BaseResultMap" type="${basePackageName}.${subPackageName}.domain.db.${tableNameHump}DO">
        <id column="id" property="id"/>
<#list columnList as column>
    <#if column.columnNameHumpLetter != "id">
        <result column="${column.columnName}" property="${column.columnNameHumpLetter}"/>
    </#if>
</#list>
    </resultMap>

    <sql id="Base_Column_List">

    </sql>

<#if pageFlag == true>
    <resultMap id="${tableNameHump}VO" type="${basePackageName}.${subPackageName}.domain.vo.${tableNameHump}VO">
        <id column="id" property="id"/>
<#list columnList as column>
    <#if column.columnNameHumpLetter != "id">
        <result column="${column.columnName}" property="${column.columnNameHumpLetter}"/>
    </#if>
</#list>
    </resultMap>
    <select id="page" resultMap="${tableNameHump}VO">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
        order by update_time desc
    </select>
</#if>
</mapper>