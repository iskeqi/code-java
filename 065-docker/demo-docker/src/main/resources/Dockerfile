# 指定基础镜像
FROM java:8-alpine
# 拷贝 jar 包
COPY ./demo-0.0.1-SNAPSHOT.jar /tmp/app.jar
# 暴露端口
EXPOSE 9909
# Java 项目的启动命令
ENTRYPOINT java -jar /tmp/app.jar

# 将 jar 包和 Dockerfile 文件都放在同一个目录下，并进入当前目录
# 使用 docker build 命令构建镜像，如： docker build -t demo:1.0.1 .
# 使用 docker run 运行该容器，如：docker run --name demo -p 9909:9909 -d 5b12e917fc17