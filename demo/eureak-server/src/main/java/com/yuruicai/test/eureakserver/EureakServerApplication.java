package com.yuruicai.test.eureakserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer// 声明这是一个Eureka Server
@SpringBootApplication
public class EureakServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EureakServerApplication.class, args);
    }

}
