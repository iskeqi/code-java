# Markdown接口文档模板

本文档为 Markdown 接口文档模板示例

# 前言

前言

## 文档使用说明

文档使用说明

| 状态码 | 说明                  |
| ------ | --------------------- |
| 200    | OK                    |
| 401    | Unauthorized          |
| 500    | Internal Server Error |

## 文档编写规范

文档编写规范

### 请求/响应参数类型

请求响应参数的类型必须遵循下面表格中的规则

| 数据类型 | 说明                            |
| -------- | ------------------------------- |
| object   | JSON 中的对象类型               |
| array    | JSON 中的数组类型               |
| int      | JSON 中的数值类型中的整数类型   |
| double   | JSON 中的数值类型中的浮点数类型 |
| string   | JSON 中的字符串类型             |
| boolean  | JSON 中的布尔类型               |

### 请求/响应参数表格排版

- 请求参数和响应参数表格中的**参数名称**一栏需要同 JSON 的层次结构一致，在参数名称前使用空格进行隔开。空格的写法为`&emsp;`

### 请求方式/请求示例

- 请求方式只允许使用 POST 和 GET ，原则上全部使用 POST ，只有无参或极少参数时允许使用 GET
- 使用 GET 请求时，请求示例中直接使用一个空花括号展示，`{}`

### 接口排列顺序

- 按照系统模块划分接口文档模块，使用中文数字区分。比如，一、二、三等。
- 单个模块中的某个功能的接口顺序，必须按照增加、删除、修改、查询单个、查询列表、其它接口的顺序进行排版。

### URL 命名规则

同一团队中的接口 URL 命名是否规范、命名风格是否一致直接决定了接口文档的质量。所以，必须要规范 URL 的命名。

- URL 命名禁止使用驼峰命名法（`CamelCase`），转而使用脊柱命名法（`spinal-case`）。所谓脊柱命名法就是使用中划线 `-` 分隔不同单词，例如`dict-type`。这是在 RFC3986 中明确建议使用的命名方式！[参考链接](https://blog.restcase.com/5-basic-rest-api-design-guidelines/)
- URL 的命名规则必须遵循 `http://ip:port/应用全局路径/模块简称/功能简称/动作/其它` 的规则，比如：`http://localhost:9102/idomp-bjzjc/sc/dict-data/get/dict-type`。
- URL 中增加、删除、修改、查询单个、分页查询这 5 个通用动作，必须固定使用`insert`、`delete`、`update`、`get`、`list`这 5 个单词表示。

# 一、系统管理模块

## 1. 代码生成管理


### 1.1 增加代码生成

**接口地址**:`http://localhost:9102/idomp-bjzjc/sc/code-gen/insert`

**请求方式**:`POST`

**请求数据类型**:`application/json`

**响应数据类型**:`application/json`

**接口描述**: 暂无

**请求示例**:


```javascript
{
	"username": "grace",
	"age": 22,   
	"weight": 63.45
}
```

**请求参数**:


| 参数名称 | 参数说明 | 是否必须 | 数据类型 |
| -------- | -------- | -------- | -------- |
|username|用户名|true|string|
|age|年龄|true|int|
|weight|体重|true|double|

**响应参数**:


| 参数名称 | 参数说明 | 类型 |
| -------- | -------- | ----- |
|status|状态码|int|
|msg|说明|string|
|body|响应体|object|

**响应示例**:

```javascript
{
	"status": 200,
	"msg": "OK",
	"body": {}
}
```


### 1.2 批量删除代码生成

**接口地址**:`http://localhost:9102/idomp-bjzjc/sc/code-gen/delete`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`application/json`

**接口描述**: 暂无


**请求示例**:


```javascript
[
	0,
    1
]
```


**请求参数**:


| 参数名称 | 参数说明 | 是否必须 | 数据类型 |
| -------- | -------- | -------- | -------- |
|ids|ids|true|array|


**响应参数**:


| 参数名称 | 参数说明 | 类型 |
| -------- | -------- | ----- |
|status|状态码|int|
|msg|说明|string|
|body|响应体|object|

**响应示例**:

```javascript
{
	"status": 200,
	"msg": "OK",
	"body": {}
}
```


### 1.3 修改代码生成

**接口地址**:`http://localhost:9102/idomp-bjzjc/sc/code-gen/update`

**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`application/json`

**接口描述**: 暂无


**请求示例**:


```javascript
{
	"id": 241,
	"username": "grace",
	"age": 22,
	"weight": 63.45
}
```


**请求参数**:


| 参数名称 | 参数说明 | 是否必须 | 数据类型 |
| -------- | -------- | -------- | -------- |
|id|主键|true|int|
|username|用户名|true|string|
|age|年龄|true|int|
|weight|体重|true|double|


**响应参数**:


| 参数名称 | 参数说明 | 类型 |
| -------- | -------- | ----- |
|status|状态码|int|
|msg|说明|string|
|body|响应体|object|


**响应示例**:
```javascript
{
	"status": 200,
	"msg": "OK",
	"body": {}
}
```


### 1.4 查询单个代码生成


**接口地址**:`http://localhost:9102/idomp-bjzjc/sc/code-gen/get`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`application/json`

**接口描述**: 暂无


**请求示例**:


```javascript
{
	"id": 8
}
```


**请求参数**:


| 参数名称 | 参数说明 | 是否必须 | 数据类型 |
| -------- | -------- | -------- | -------- |
|id|主键|true|int|


**响应参数**:


| 参数名称 | 参数说明 | 类型 |
| -------- | -------- | ----- |
|status|状态码|int|
|msg|说明|string|
|body|响应体|object|
|&emsp;&emsp;id|主键|int|
|&emsp;&emsp;username|用户名|string|
|&emsp;&emsp;age|年龄|int|
|&emsp;&emsp;weight|体重|double|
|&emsp;&emsp;createTime|创建时间|string|


**响应示例**:
```javascript
{
	"status": 200,
	"msg": "OK",
	"body": {
		"id": 201,
		"username": "grace",
		"age": 29,
		"weight": 67.43,
		"createTime": "2019-12-12 12:32:34"
	}
}
```


### 1.5 查询列表代码生成

**接口地址**:`http://localhost:9102/idomp-bjzjc/sc/code-gen/list`

**请求方式**:`POST`

**请求数据类型**:`application/json`


**响应数据类型**:`application/json`

**接口描述**: 暂无


**请求示例**:


```javascript
{
	"username": "grace",
	"age": 22,
	"weight": 63.45,
	"current": 1,
	"size": 20
}
```


**请求参数**:


| 参数名称 | 参数说明 | 是否必须 | 数据类型 |
| -------- | -------- | -------- | -------- |
|username|用户名|false|string|
|age|年龄|false|int|
|weight|体重|false|double|
|current|当前页数|true|int|
|size|每页大小|true|int|


**响应参数**:


| 参数名称 | 参数说明 | 类型 |
| -------- | -------- | ----- |
|status|状态码|int|
|msg|说明|string|
|body|响应体|object|
|&emsp;&emsp;total|总记录数|int|
|&emsp;&emsp;records|记录列表|array|
|&emsp;&emsp;&emsp;&emsp;id|主键|int|
|&emsp;&emsp;&emsp;&emsp;username|用户名|string|
|&emsp;&emsp;&emsp;&emsp;age|年龄|int|
|&emsp;&emsp;&emsp;&emsp;weight|体重|double|
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string|

**响应示例**:

```javascript
{
	"status": 200,
	"msg": "OK",
	"body": {
		"total": 200,
		"records": [
			{
				"id": 201,
				"username": "grace",
				"age": 29,
				"weight": 67.43,
				"createTime": "2019-12-12 12:32:34"
			}
		]
	}
}
```