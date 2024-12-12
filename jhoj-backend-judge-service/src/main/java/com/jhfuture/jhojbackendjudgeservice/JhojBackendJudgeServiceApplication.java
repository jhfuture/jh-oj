package com.jhfuture.jhojbackendjudgeservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.jhfuture")
@EnableDiscoveryClient //开始服务发现，让 其去 nacons 上去找服务
@EnableFeignClients(basePackages = "com.jhfuture.jhojbackendserviceclient.service") //服务启动时会自动将需要的实现类注入到需要的容器中
public class JhojBackendJudgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JhojBackendJudgeServiceApplication.class, args);
    }

}
