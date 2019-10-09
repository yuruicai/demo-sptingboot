package com.yuruicai.test.server.springcloud;

import com.yuruicai.test.server.springcloud.service.Strategy.SimpleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RepositoryRestResource(collectionResourceRel = "sms", path = "sms")
@RestController
//@RequestMapping("sms")
public class SmsController /*extends PagingAndSortingRepository<SmsDomain, Long>*/ {

    @GetMapping("sms")
    public Object getSms(){
        return "调用smsget方法。。。。。。。。";
    }

    @Autowired
    private SimpleContext simpleContext;

    @GetMapping("/choose")
    public String choose(@RequestParam String poolId){
        return simpleContext.getResource(poolId);
    }

}