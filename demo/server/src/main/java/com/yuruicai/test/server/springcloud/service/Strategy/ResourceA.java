package com.yuruicai.test.server.springcloud.service.Strategy;


import org.springframework.stereotype.Component;

@Component("A")
public class ResourceA implements Strategy {

    @Override
    public String getVpcList(String id) {
        System.out.println("A,getVpcList ==========="+id);
        return id;
    }
}
