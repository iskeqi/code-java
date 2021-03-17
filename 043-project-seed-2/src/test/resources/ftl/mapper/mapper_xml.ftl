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
        <#elseif column.columnTypeJava != "String" && column.columnNameHumpLetter != 'createTime' && column.columnNameHumpLetter != 'updateTime' && column.columnNameHumpLetter != 'id'>
            <if test="${column.columnNameHumpLetter} != null">
                ${column.columnName},
            </if>
        <#elseif column.columnNameHumpLetter == 'createTime'>
            create_time,
        <#elseif column.columnNameHumpLetter == 'updateTime'>
            update_time,
        </#if>
        </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
        <#list columnList as column>
        <#if column.columnTypeJava == "String">
            <if test="${column.columnNameHumpLetter} != null and ${column.columnNameHumpLetter} != ''">
                ${r'#'}{${column.columnNameHumpLetter}},
            </if>
        <#elseif column.columnTypeJava != "String" && column.columnNameHumpLetter != 'createTime' && column.columnNameHumpLetter != 'updateTime' && column.columnNameHumpLetter != 'id'>
            <if test="${column.columnNameHumpLetter} != null">
                ${r'#'}{${column.columnNameHumpLetter}},
            </if>
        <#elseif column.columnNameHumpLetter == 'createTime'>
            now(),
        <#elseif column.columnNameHumpLetter == 'updateTime'>
            now(),
        </#if>
        </#list>
        </trim>
    </insert>

    <insert id="insertList">
        insert into ${tableName}(
        <trim suffixOverrides=",">
            <#list columnList as column><#if column.columnNameHumpLetter == 'createTime'>create_time, <#elseif column.columnNameHumpLetter == 'updateTime'>update_time, <#elseif column.columnNameHumpLetter != 'id'>${column.columnName}, </#if></#list>
        </trim>
        ) values
        <foreach collection="list" item="element" index="index" separator=",">
            (
            <trim suffixOverrides=",">
                <#list columnList as column><#if column.columnNameHumpLetter == 'createTime'>now(), <#elseif column.columnNameHumpLetter == 'updateTime'>now(), <#elseif column.columnNameHumpLetter != 'id'> ${r'#'}{element.${column.columnNameHumpLetter}}, </#if></#list>
            </trim>
            )
        </foreach>
    </insert>

    <update id="updateById">
        update ${tableName}
        <set>
    <#list columnList as column>
    <#if column.columnTypeJava == "String">
            <if test="${column.columnNameHumpLetter} != null and ${column.columnNameHumpLetter} != ''">
                ${column.columnName} = ${r'#'}{${column.columnNameHumpLetter}},
            </if>
    <#elseif column.columnTypeJava != "String" && column.columnNameHumpLetter != 'createTime' && column.columnNameHumpLetter != 'updateTime' && column.columnNameHumpLetter != 'id'>
            <if test="${column.columnNameHumpLetter} != null">
                ${column.columnName} = ${r'#'}{${column.columnNameHumpLetter}},
            </if>
    <#elseif column.columnNameHumpLetter == 'updateTime'>
            update_time = now(),
    </#if>
    </#list>
        </set>
        where id = ${r'#'}{id}
    </update>

    <update id="update">
        update ${tableName}
        <set>
    <#list columnList as column>
        <#if column.columnTypeJava == "String">
            <if test="t.${column.columnNameHumpLetter} != null and t.${column.columnNameHumpLetter} != ''">
                ${column.columnName} = ${r'#'}{t.${column.columnNameHumpLetter}},
            </if>
        <#elseif column.columnTypeJava != "String" && column.columnNameHumpLetter != 'createTime' && column.columnNameHumpLetter != 'updateTime' && column.columnNameHumpLetter != 'id'>
            <if test="t.${column.columnNameHumpLetter} != null">
                ${column.columnName} = ${r'#'}{t.${column.columnNameHumpLetter}},
            </if>
        <#elseif column.columnNameHumpLetter == 'updateTime'>
            update_time = now(),
        </#if>
    </#list>
        </set>
        where
        <trim prefixOverrides="and">
    <#list columnList as column>
        <#if column.columnTypeJava == "String">
            <if test="con.${column.columnNameHumpLetter} != null and con.${column.columnNameHumpLetter} != ''">
                and ${column.columnName} = ${r'#'}{con.${column.columnNameHumpLetter}}
            </if>
        <#elseif column.columnTypeJava != "String">
            <if test="con.${column.columnNameHumpLetter} != null">
                and ${column.columnName} = ${r'#'}{con.${column.columnNameHumpLetter}}
            </if>
        </#if>
    </#list>
        </trim>
    </update>

    <delete id="deleteById">
        delete
        from ${tableName}
        where id = ${r'#'}{id}
    </delete>

    <delete id="deleteByIds">
        delete
        from ${tableName} where id in
        <foreach item="item" collection="ids" open="(" separator="," close=")">
            ${r'#'}{item}
        </foreach>
    </delete>

    <delete id="delete">
        delete
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
    </delete>

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

    <select id="findByIds" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName} where id in
        <foreach item="item" collection="ids" open="(" separator="," close=")">
            ${r'#'}{item}
        </foreach>
    </select>

    <select id="findList" resultMap="BaseResultMap">
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

</mapper>