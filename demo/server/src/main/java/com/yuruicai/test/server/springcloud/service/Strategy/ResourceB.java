package com.yuruicai.test.server.springcloud.service.Strategy;

import org.springframework.stereotype.Component;

@Component("B")
public class ResourceB implements Strategy {

    @Override
    public String getVpcList(String id) {
        System.out.println("B strategy"+"====="+id);
        return id;
    }
 }
