Docker部署SpringBoot项目流程：
1. 创建springboot项目
2. 打包springboot项目为jar包
3. 编写Dockerfile文件
    # Docker image for springboot file run
    # VERSION 0.0.1
    # Author: flying
    # 基础镜像使用java
    FROM java:8
    # 作者
    MAINTAINER flying
    # VOLUME 指定了临时文件目录为/tmp。
    # 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
    VOLUME /tmp
    # 将jar包添加到容器中并更名为app.jar
    ADD automation-testing-0.0.1-SNAPSHOT.jar automation-testing-0.0.1-SNAPSHOT.jar
    # 运行jar包
    RUN bash -c 'touch /automation-testing-0.0.1-SNAPSHOT.jar'
    ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/automation-testing-0.0.1-SNAPSHOT.jar"]
4. 部署文件
      在服务器新建一个docker文件夹，将maven打包好的jar包和Dockerfile文件复制到服务器的docker文件夹下
5. 制作镜像
     docker build -t automation-testing-docker .
   制作完成后通过docker images命令查看我们制作的镜像
6. 启动容器
   docker run --name automation-testing-docker -d -v /opt/docker-project/log:/opt/docker-project/log -p 8081:8081 automation-testing-docker
   解释说明：
    run: 容器启动命令
    --name automation-testing-docker 自定义容器命名
    -d 程序后台启动
    -v /opt/jar/boot-docker/logs:/log 应用日志 数据卷的方式存储
    -p 8081:8081 用主机8081端口映射容器端口
    boot-docker 镜像名称
7. 访问网站