### ${name}

**接口地址**：`${url}`

**请求方式**：`${requestMethod}`

**请求数据类型**：`${requestContentType}`

**响应数据类型**：`${responseContentType}`

**接口描述**：暂无

**请求示例**：

```javascript
${requestDemo}
```

**请求参数**：

| 参数名称 | 参数说明 | 是否必须 | 数据类型 |
| -------- | -------- | -------- | -------- |
<#list requestParamList as value>
    |${value.name}|${value.note}|${value.required}|${value.type}|
</#list>

**响应参数**：

| 参数名称 | 参数说明 | 类型 |
| -------- | -------- | ----- |
<#list requestParamList as value>
    |${value.name}|${value.note}|${value.type}|
</#list>

**响应示例**：

```javascript
${responseDemo}
```