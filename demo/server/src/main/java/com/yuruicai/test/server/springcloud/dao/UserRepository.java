package com.yuruicai.test.server.springcloud.dao;

import com.yuruicai.test.server.springcloud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByIdAndName(long id ,String name);
}