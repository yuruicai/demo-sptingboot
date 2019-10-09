package com.yuruicai.test.server.springcloud;

import com.yuruicai.test.server.springcloud.dao.DepartmentRepository;
import com.yuruicai.test.server.springcloud.dao.RoleRepository;
import com.yuruicai.test.server.springcloud.dao.UserRepository;
import com.yuruicai.test.server.springcloud.domain.User;
import com.yuruicai.test.server.springcloud.service.Strategy.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    private static Logger logger = LoggerFactory.getLogger(controller.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserService userService;

    @RequestMapping("v1/user")
    public Object select(@RequestBody User user){
        Object byName = userService.selectUser(user);
        return byName;
    }

}