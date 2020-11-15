package com.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.model.Employee;
import com.springbootdemo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository er;

	public void addEmployee(Employee emp) {
		er.save(emp);
	}

	public void deleteEmployee(int id) {
		er.deleteById(id);
	}

	public List<Employee> getAllEmployee() {
		return (List<Employee>) er.findAll();
	}
	
	public Boolean employeeExists(String id){
		if(er.existsById(Integer.parseInt(id)))
			return true;
		else
			return false;
		
	}

}
