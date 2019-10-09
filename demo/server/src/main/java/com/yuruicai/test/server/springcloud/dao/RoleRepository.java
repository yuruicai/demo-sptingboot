package com.yuruicai.test.server.springcloud.dao;

import com.yuruicai.test.server.springcloud.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
