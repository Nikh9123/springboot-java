package com.nikhil.springboot.cruddemo2.rest;


import com.nikhil.springboot.cruddemo2.dao.EmployeeDAO;
import com.nikhil.springboot.cruddemo2.entity.Employee;
import com.nikhil.springboot.cruddemo2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService ;

    //quick and dirty : inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService ;
    }
    //expose and return the a list of employee
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll() ;
    }

    @GetMapping("/employee/{employeeId}")
    public  Employee findById(@PathVariable Integer employeeId){
        Employee theEmployee =  employeeService.findById(employeeId) ;

        if(theEmployee == null){
            throw new RuntimeException("Employee not found!!!" + employeeId) ;
        }
        return theEmployee ;
    }


    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //post ==> request to add employee in database
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee) ;
        return dbEmployee  ;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee TheEmployee){
        Employee dbEmployee = employeeService.save(TheEmployee) ;

        return dbEmployee ;
    }

}
