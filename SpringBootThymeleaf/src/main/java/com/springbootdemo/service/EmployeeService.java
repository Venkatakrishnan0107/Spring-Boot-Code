package com.springbootdemo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.session.HazelcastSessionProperties;
import org.springframework.stereotype.Service;

import com.springbootdemo.model.Employee;

@Service
public class EmployeeService {
	
	HashMap<Integer, Employee> empMap = new HashMap();
	
	public EmployeeService()
	{
		
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setFirstName("S");
		e1.setLastName("Venkat");
		e1.setAge(26);		
		empMap.put(1, e1);
		
		e1 = new Employee();
		
		e1.setId(2);
		e1.setFirstName("Midhun");
		e1.setLastName("Sankar");
		e1.setAge(25);		
		empMap.put(2, e1);
	}
	
	public Employee getEmployee(int id)
	{
		if(empMap.containsKey(id))
			return empMap.get(id);
		else
			return null;
	}
	
	public Map<Integer, Employee> getAll()
	{
		return empMap;
	}
	
	public void addEmployee(Employee emp)
	{
		empMap.put(emp.getId(), emp);
	}

}
