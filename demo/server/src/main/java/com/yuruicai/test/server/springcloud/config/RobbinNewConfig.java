package com.yuruicai.test.server.springcloud.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name="MS-SIMPLE-PROVIDER-USER",configuration=RobbinConfig.class)
public class RobbinNewConfig {

}