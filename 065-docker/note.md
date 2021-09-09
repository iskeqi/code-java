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

### 容器操作命令

![image-20210907233040719](D:\KEQI\MyCode\code-java\065-docker\images\image-20210907233040719.png)