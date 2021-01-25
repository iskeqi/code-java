# 项目说明文档

## 待做事项

- 防止重复提交
- 防止XSS攻击
- do/mapper/mapper_xml 还是使用插件生成，其他用模板生成，去改动一下
- 引入 redis ，将用户的角色、权限信息存到redis中，以及登录，字典信息。同时兼容没有 redis 版本

## 部署说明

项目打成单独 jar 包后，使用 java -jar 命令启动即可。

### 注意事项

- 本项目上传文件默认会放在 jar 包所处的同级目录中，如 jar 包的全路径是 /data/app/xxx.jar，那么上传文件所处的路径是：
    - 私有文件路径：/data/app/uploadFile/privateFile/xxxxxx
    - 公开文件路径：/data/app/uploadFile/publicFile/xxxxxx


