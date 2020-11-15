package com.springbootdemo.repository;

import org.springframework.stereotype.Repository;

import com.springbootdemo.model.Employee;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Serializable>{

}
