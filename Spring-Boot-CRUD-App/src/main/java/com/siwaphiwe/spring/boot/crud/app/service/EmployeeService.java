package com.siwaphiwe.spring.boot.crud.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import aj.org.objectweb.asm.ConstantDynamic;
import com.siwaphiwe.spring.boot.crud.app.exception.ApiRequestException;
import com.siwaphiwe.spring.boot.crud.app.persistence.EmployeeRepository;
import com.siwaphiwe.spring.boot.crud.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final EntityManager entityManager;




    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EntityManager entityManager){

        this.employeeRepository= employeeRepository;
        this.entityManager = entityManager;

    }
    @Transactional
    public List<Employee> getAll() {

        List<Employee> employees = new ArrayList<>();
        return employeeRepository.findAll();
    }
    @Transactional
    public void addEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    @Transactional
    public Optional<Employee> getEmployeeById(int id) {

        return employeeRepository.findById(id);
    }

    @Transactional
    public List<Employee> getByName(String name){

            return employeeRepository.findByName(name);
    }

    @Transactional
    public void updateEmployee( int id,Employee employee) {

        employeeRepository.save(employee);

    }

    @Transactional
    public void deleteById(int id) {

        employeeRepository.deleteById(id);
    }



}
