package com.nikhil.springboot.cruddemo2.dao;

import com.nikhil.springboot.cruddemo2.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entity manager
    private EntityManager entityManager ;


    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager ;

    }
    @Override
    public Employee save(Employee theEmployee){
        Employee dbEmployee = entityManager.merge(theEmployee) ;
        return dbEmployee  ;
    }

    @Override
    public Employee findById(Integer theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId) ;

        //return the employee
        return theEmployee ;
    }

    @Override
    public void deleteById(int theId){
        Employee theEmployee = entityManager.find(Employee.class, theId) ;

        entityManager.remove(theEmployee);

    }

    @Override
    public Employee findOne(String field){ //field ==> can be first_name or last_name
        //get the employee
        TypedQuery<Employee> theQuery = entityManager.createQuery(field, Employee.class) ;
        //return the employee
         Employee theEmployee = theQuery.getSingleResult() ;

         return theEmployee ;
    }
    @Override
    public List<Employee> findAll(){
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        // execute the query and get employee list
        List<Employee> employeeList = theQuery.getResultList() ;
        //return the list
        return employeeList ;
    }
}
