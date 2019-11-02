package com.yuruicai.test.server.springcloud.service.Impl;

import com.yuruicai.test.common.bean.UserDto;
import com.yuruicai.test.server.springcloud.dao.UserRepository;
import com.yuruicai.test.server.springcloud.domain.User;
import com.yuruicai.test.server.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private RestTemplate restTemplate;

    @Transactional
    public User selectUser(User user) {
        User byName = userRepository.findByIdAndName(user.getId(),user.getName());
        if(byName != null){
            applicationEventPublisher.publishEvent(byName);
        }
        return byName;
    }

    @Override
    public User selectUserRibbon(User user) {
        ResponseEntity<User> forEntity = restTemplate.getForEntity("http://LESSION-3-FEIGN/v1/user/?id={1}", User.class, user.getId());
        return forEntity.getBody();
    }

    public List<User> findUserPage(UserDto userDto) {
        return Collections.EMPTY_LIST;
    }

}
