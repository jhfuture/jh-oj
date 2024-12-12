#基础镜像
FROM openjdk:8-jdk-alpine
#执行工作目录 相当于 cd
WORKDIR /app
# 拷贝 jar包
ADD target/jhoj-backend-question-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8101

ENTRYPOINT ["java", "-jar", "jhoj-backend-question-service-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]
