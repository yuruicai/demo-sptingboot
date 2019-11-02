package com.yuruicai.test.resfull.api.controller;

import com.yuruicai.test.resfull.service.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.LoggerFactory;


@RestController("ribbon")
public class RibbonController {
    private static Logger logger = LoggerFactory.getLogger(RibbonController.class);

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("v1/user")
    public Object select(@RequestParam("id") long userId){
        Object byName = userServiceImpl.selectUser(userId);
        return byName;
    }

}