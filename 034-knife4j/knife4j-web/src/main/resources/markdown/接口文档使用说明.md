# 接口文档使用说明

## 接口响应参数

接口响应参数统一使用了 code/message/data 3 个字段包裹，但是在接口文档中并不会去体现出来，通过 debug 调试功能查看具体示例可清晰看到。
- 响应参数 code 有以下几种状态码
    - 200：响应成功
    - 500：响应失败
    - 401：未登录

```json
{
  "code": 200,
  "message": "OK",
  "data": {}
}
```

## 接口命名

接口命名规则如下：

- 新增：post + /模块名/资源名称
    - 示例： post + /sys/account
- 修改：put + /模块名/资源名称
    - 示例： put + /sys/account
- 删除：delete + /模块名/资源名称/id
    - 示例： delete + /sys/account/1
- 详情：get + /模块名/资源名称/id
    - 示例： get + /sys/account/1
- 分页：post + /模块名/资源名称/page
    - 示例： post + /sys/account/page
- 其他：post + /模块名/资源名称/操作名称
    - 示例： post + /sys/account/disable


## 访问 token

调用登录接口后，会返回一个 accessToken 参数。将此参数在每个需要鉴权的 http 请求 header 中带上即可。

## 字典使用

调用 `2.5 根据 typeCode 查询字典项列表` 接口，会返回指定 `typeCode` 对用的字典项列表。`typeCode` 的值则会在每个需要用到字典数据参数中描述清楚