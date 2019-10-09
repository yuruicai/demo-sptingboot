package com.yuruicai.test.server.springcloud.service.Strategy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SimpleContext {

    @Autowired
    private final Map<String, Strategy> strategyMap = new ConcurrentHashMap<>();
    public SimpleContext(Map<String, Strategy> strategyMap) {
        new HashMap();
        this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
    }

    public String getResource(String poolId){
        return strategyMap.get(poolId).getVpcList(poolId);
    }
}
