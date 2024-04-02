package com.nikhil.springboot.cruddemo2.service;

import com.nikhil.springboot.cruddemo2.entity.Employee;

import java.util.List;

public interface EmployeeService{

    //create the fields

    List<Employee>findAll() ;
    Employee findOne(String field) ;
    Employee findById(Integer theId) ;
    Employee save(Employee employee) ;
    void deleteById(int theId) ;
}
