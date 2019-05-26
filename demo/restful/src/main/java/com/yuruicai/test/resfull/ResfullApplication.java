package com.yuruicai.test.resfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(defaultConfiguration= FeignClientsConfiguration.class)
public class ResfullApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResfullApplication.class, args);
    }

}
