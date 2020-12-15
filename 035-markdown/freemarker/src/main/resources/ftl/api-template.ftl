<#list moduleList as module>
# ${module.moduleName}
<#list module.groupList as group>
## ${group.groupName}
<#list group.apiList as api>
### ${api.name}

**接口地址**：`${api.url}`

**请求方式**：`${api.requestMethod}`

**请求数据类型**：`${api.requestContentType}`

**响应数据类型**：`${api.responseContentType}`

<#if api.note ??>
**接口描述**：${api.note}
</#if>

**请求示例**：

```javascript
${api.requestDemo}
```

**请求参数**：

| 参数名称 | 参数说明 | 是否必须 | 数据类型 |
| -------- | -------- | -------- | -------- |
<#list api.requestParamList as value>
    |${value.name}|${value.note}|${value.required}|${value.type}|
</#list>

**响应参数**：

| 参数名称 | 参数说明 | 类型 |
| -------- | -------- | ----- |
<#list api.requestParamList as value>
    |${value.name}|${value.note}|${value.type}|
</#list>

**响应示例**：

```javascript
${api.responseDemo}
```
</#list>
</#list>
</#list>