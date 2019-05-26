package com.yuruicai.test.server.springcloud;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RepositoryRestResource(collectionResourceRel = "sms", path = "sms")
@RestController
//@RequestMapping("sms")
public class SmsController /*extends PagingAndSortingRepository<SmsDomain, Long>*/ {

    @GetMapping("sms")
    public Object getSms(){
        return "调用smsget方法。。。。。。。。";
    }
}