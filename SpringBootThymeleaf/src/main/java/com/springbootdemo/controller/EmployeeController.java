package com.springbootdemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbootdemo.model.Employee;
import com.springbootdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	
	@RequestMapping("{id}")
	 public String getEmployee(Model model,@PathVariable("id") String id)
	 {
		 Employee emp = es.getEmployee(Integer.parseInt(id));
		 model.addAttribute("employee", emp);
		 return "employeeView";
		 
	 }
	 
	 @RequestMapping("/all")
	 @ResponseBody
	 public Map<Integer,Employee> getAllEmployee()
	 {
		 return es.getAll();
	 }

		@RequestMapping("addformsave")
		public String getPerson(Model model,Employee p) {
			System.out.println("Updated first name is "+p.getFirstName());

			System.out.println("Updated last name is "+p.getLastName());

			System.out.println("Updated age is "+p.getAge());
			return "employeeView";
		}
	 

}
