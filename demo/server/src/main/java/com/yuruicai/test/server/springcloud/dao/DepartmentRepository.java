package com.yuruicai.test.server.springcloud.dao;


import com.yuruicai.test.server.springcloud.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
