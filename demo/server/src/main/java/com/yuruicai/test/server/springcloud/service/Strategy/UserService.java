package com.yuruicai.test.server.springcloud.service.Strategy;

import com.yuruicai.test.server.springcloud.dao.UserRepository;
import com.yuruicai.test.server.springcloud.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @Transactional
    public Object selectUser(User user){
        User byName = userRepository.findByName(user.getName());
        applicationEventPublisher.publishEvent(byName);
        return byName;
    }
}
