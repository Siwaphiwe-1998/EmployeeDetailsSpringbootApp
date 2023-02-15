package com.siwaphiwe.spring.boot.crud.app.persistence;

import com.siwaphiwe.spring.boot.crud.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);
    Employee getById(int id);
    Boolean existsByEmail(String email);
    Boolean existsByName(String name);



}