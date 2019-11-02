package com.yuruicai.test.resfull.service.serviceImpl;

import com.yuruicai.test.resfull.dao.UserRepository;
import com.yuruicai.test.resfull.domin.User;
import com.yuruicai.test.resfull.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Object selectUser(long userId){
        User byName = userRepository.findById(userId);
        applicationEventPublisher.publishEvent(byName);
        return byName;
    }
}
