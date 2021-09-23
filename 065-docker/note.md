# docker

## Docker 与虚拟机

![](D:\KEQI\MyCode\code-java\065-docker\images\Snipaste_2021-09-07_22-39-07.png)

## 镜像和容器

镜像（image）：Docker 将应用程序及其所需的依赖、函数库、环境、配置等文件打包在一起，成为镜像

容器（container）：镜像中的应用程序运行后形成的进程就是容器，只是Docker 会给容器做隔离，对外不可见

## Docker 架构

![image-20210907224724973](D:\KEQI\MyCode\code-java\065-docker\images\image-20210907224724973.png)



## 安装 Docker

直接去查看官方文档中关于 docker 安装部分的文档看看就行，照着做就好了，超级简单。 

## Docker 操作镜像

镜像名称一般分两部分组成：[repository]:[tag] ，如 mysql:5.7，如果不写 tag 默认使用 latest，一般来说代表最新镜像，但不是强制规定，只是一种约定

### 镜像操作命令

![image-20210907231002014](D:\KEQI\MyCode\code-java\065-docker\images\image-20210907231002014.png)

## 容器操作命令

![image-20210907233040719](D:\KEQI\MyCode\code-java\065-docker\images\image-20210907233040719.png)

## 数据卷

![image-20210914192022651](D:\KEQI\MyCode\code-java\065-docker\images\image-20210914192022651.png)

![image-20210914192504267](D:\KEQI\MyCode\code-java\065-docker\images\image-20210914192504267.png)

![image-20210914192618310](D:\KEQI\MyCode\code-java\065-docker\images\image-20210914192618310.png)

### 数据卷挂载的区别

![image-20210914201631704](D:\KEQI\MyCode\code-java\065-docker\images\image-20210914201631704.png)

推荐用数据卷的方式进行挂载

## Dockerfile 自定义镜像

镜像是将应用程序及其需要的系统函数库、环境、配置、依赖打包而成。

![image-20210914202534280](D:\KEQI\MyCode\code-java\065-docker\images\image-20210914202534280.png)

![image-20210914202703621](D:\KEQI\MyCode\code-java\065-docker\images\image-20210914202703621.png)

![image-20210914202831846](D:\KEQI\MyCode\code-java\065-docker\images\image-20210914202831846.png)

![image-20210914210131513](D:\KEQI\MyCode\code-java\065-docker\images\image-20210914210131513.png)

## DockerCompose

![image-20210914213418318](D:\KEQI\MyCode\code-java\065-docker\images\image-20210914213418318.png)

dockercompose 实际上就是把 docker run 命令的各种参数转换成了 compose 中的命令，实际上表达的还是一个意思。
