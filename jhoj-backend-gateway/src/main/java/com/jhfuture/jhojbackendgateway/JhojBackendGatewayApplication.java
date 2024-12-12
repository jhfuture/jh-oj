package com.jhfuture.jhojbackendgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient //开始服务发现，让 其去 nacons 上去找服务
public class JhojBackendGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JhojBackendGatewayApplication.class, args);
    }

}
