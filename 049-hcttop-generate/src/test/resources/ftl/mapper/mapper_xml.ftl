<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackageName}.${subPackageName}.mapper.${tableNameHump}Mapper">
    <resultMap id="BaseResultMap" type="${basePackageName}.${subPackageName}.entity.${tableNameHump}">
        <!--@mbg.generated-->
        <!--@Table ${tableName}-->
        <id column="id" property="id"/>
<#list columnList as column>
    <#if column.columnNameHumpLetter != "id">
        <result column="${column.columnName}" property="${column.columnNameHumpLetter}"/>
    </#if>
</#list>
    </resultMap>

    <sql id="Base_Column_List">
        <!--@mbg.generated-->
        <#list columnList as column>${column.columnName}<#sep>, </#list>
    </sql>

    <insert id="insert" keyProperty="id" useGeneratedKeys="true">
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
        <#list columnList as column>
        <#if column.columnTypeJava == "String">
            <if test="${column.columnNameHumpLetter} != null and ${column.columnNameHumpLetter} != ''">
                ${column.columnName},
            </if>
        <#elseif column.columnTypeJava != "String" && column.columnNameHumpLetter != 'createDate' && column.columnNameHumpLetter != 'updateDate' && column.columnNameHumpLetter != 'id'>
            <if test="${column.columnNameHumpLetter} != null">
                ${column.columnName},
            </if>
        <#elseif column.columnNameHumpLetter == 'createDate'>
            create_date,
        <#elseif column.columnNameHumpLetter == 'updateDate'>
            update_date,
        </#if>
        </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
        <#list columnList as column>
        <#if column.columnTypeJava == "String">
            <if test="${column.columnNameHumpLetter} != null and ${column.columnNameHumpLetter} != ''">
                ${r'#'}{${column.columnNameHumpLetter}},
            </if>
        <#elseif column.columnTypeJava != "String" && column.columnNameHumpLetter != 'createDate' && column.columnNameHumpLetter != 'updateDate' && column.columnNameHumpLetter != 'id'>
            <if test="${column.columnNameHumpLetter} != null">
                ${r'#'}{${column.columnNameHumpLetter}},
            </if>
        <#elseif column.columnNameHumpLetter == 'createDate'>
            now(),
        <#elseif column.columnNameHumpLetter == 'updateDate'>
            now(),
        </#if>
        </#list>
        </trim>
    </insert>

    <insert id="batchInsert">
        insert into ${tableName}(
        <trim suffixOverrides=",">
            <#list columnList as column><#if column.columnNameHumpLetter == 'createDate'>create_date, <#elseif column.columnNameHumpLetter == 'updateDate'>update_date, <#elseif column.columnNameHumpLetter != 'id'>${column.columnName}, </#if></#list>
        </trim>
        ) values
        <foreach collection="list" item="element" index="index" separator=",">
            (
            <trim suffixOverrides=",">
                <#list columnList as column><#if column.columnNameHumpLetter == 'createDate'>now(), <#elseif column.columnNameHumpLetter == 'updateDate'>now(), <#elseif column.columnNameHumpLetter != 'id'> ${r'#'}{element.${column.columnNameHumpLetter}}, </#if></#list>
            </trim>
            )
        </foreach>
    </insert>

    <delete id="removeById">
        delete
        from ${tableName}
        where id = ${r'#'}{id}
    </delete>

    <update id="update">
        update ${tableName}
        <set>
    <#list columnList as column>
    <#if column.columnTypeJava == "String">
            <if test="${column.columnNameHumpLetter} != null and ${column.columnNameHumpLetter} != ''">
                ${column.columnName} = ${r'#'}{${column.columnNameHumpLetter}},
            </if>
    <#elseif column.columnTypeJava != "String" && column.columnNameHumpLetter != 'createDate' && column.columnNameHumpLetter != 'updateDate' && column.columnNameHumpLetter != 'id'>
            <if test="${column.columnNameHumpLetter} != null">
                ${column.columnName} = ${r'#'}{${column.columnNameHumpLetter}},
            </if>
    <#elseif column.columnNameHumpLetter == 'updateTime'>
            update_date = now(),
    </#if>
    </#list>
        </set>
        where id = ${r'#'}{id}
    </update>

    <select id="findById" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
        where id = ${r'#'}{id}
    </select>

    <select id="find" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName} where
        <trim prefixOverrides="and">
    <#list columnList as column>
        <#if column.columnTypeJava == "String">
            <if test="${column.columnNameHumpLetter} != null and ${column.columnNameHumpLetter} != ''">
                and ${column.columnName} = ${r'#'}{${column.columnNameHumpLetter}}
            </if>
        <#elseif column.columnTypeJava != "String">
            <if test="${column.columnNameHumpLetter} != null">
                and ${column.columnName} = ${r'#'}{${column.columnNameHumpLetter}}
            </if>
        </#if>
    </#list>
        </trim>
    </select>

    <select id="pageQueryCount" resultMap="BaseResultMap">
        select count(*)
        from ${tableName}
    </select>

    <select id="pageQuery" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
    </select>
</mapper>