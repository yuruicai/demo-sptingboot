package com.yuruicai.test.server.controller;

import com.yuruicai.test.common.bean.UserDto;
import com.yuruicai.test.server.springcloud.domain.User;
import com.yuruicai.test.server.springcloud.service.Impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("v2/user")
    public Object select(@RequestBody User user) {
        Object byName = userService.selectUser(user);
        return byName;
    }
    @RequestMapping("v3/user")
    public Object select2(@RequestBody User user) {
        Object byName = userService.selectUserRibbon(user);
        return byName;
    }

    @PostMapping("/findUserPage")
    public List<User> findUserPage(@RequestBody UserDto userDto) {
        return userService.findUserPage(userDto);
    }

}