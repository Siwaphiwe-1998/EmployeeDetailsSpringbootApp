package com.siwaphiwe.spring.boot.crud.app.rest;
import java.util.List;
import java.util.Optional;

import com.siwaphiwe.spring.boot.crud.app.exception.ApiRequestException;
import com.siwaphiwe.spring.boot.crud.app.persistence.EmployeeRepository;
import com.siwaphiwe.spring.boot.crud.app.service.EmployeeService;
import com.siwaphiwe.spring.boot.crud.app.entity.Employee;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api")
public class EmployeeController {


    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;


    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository){

        this.employeeService = employeeService;

        this.employeeRepository = employeeRepository;

    }

    @PostMapping("/employee")
    @ApiOperation(value= "Saves new record of an employee")
    @ResponseBody
    public void  addEmployee(@RequestBody Employee employee) {

        if(employeeRepository.existsByEmail(employee.getEmail())){
            throw new ApiRequestException(String.format("Employee with email :%s already exists ", employee.getEmail()));
        }
            log.info("Creating new employee record");
            employeeService.addEmployee(employee);
    }

    @GetMapping("/employee")
    @ApiOperation(value= "Retrieves all employees on the table")
    public List<Employee> getAll(){

            log.info("Retrieving all employee records on the database");
            return employeeService.getAll();
    }

    @GetMapping("/employee/{id}")
    @ApiOperation(value= "Gets the records of the employee by ID")
    public Optional<Employee> getEmployeeById(@RequestParam("id") int id) {

         if (employeeRepository.existsById(id)) {
             throw new ApiRequestException("Sorry, ID:"+id+""+"does not exist");
         }
         return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee/{name}")
    @ApiOperation(value= "Gets the records of the employee by name")
    public List<Employee> getByName(@RequestParam String name) {

        if (!employeeRepository.existsByName(name)){
            throw  new ApiRequestException("No employee by the name of:"+name);
        }
            log.info("Retrieving employee records by name");
            return employeeService.getByName(name);
    }

    @PutMapping("/employee/{id}")
    @ApiOperation(value= "Updates the existing record of an employee")
    public void updateEmployee(@PathVariable int id,@RequestBody Employee employee ) {

        employee.setId(id);
        if (employeeRepository.existsById(id)) {
            throw new ApiRequestException("Sorry, ID:"+""+id+""+"does not exist");
        }

        log.info("Updating employee record by id");
        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    @ApiOperation(value= "Delete employee by ID")
    public void deleteById(@PathVariable int id) {

        if (employeeRepository.existsById(id)) {
            throw new ApiRequestException("Sorry the record you are trying to delete does not exist");
        }

        log.info("Deleting employee record by id");
        employeeService.deleteById(id);

    }
}
