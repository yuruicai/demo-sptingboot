package com.yuruicai.test.server.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobbinConfig {

    @Bean
    public IRule robbinRule(){
        return new RandomRule();
    }
}
