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
import org.springframework.web.servlet.ModelAndView;

import com.springbootdemo.model.Employee;
import com.springbootdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService es;
	
	@RequestMapping("/showAll")
	public String showAllEmployee(Model model) {
		model.addAttribute("employeeDetails", es.getAll());
		return "employeeList";
	}

	@RequestMapping("/addEmployee")
	public String addEmpolyeeDetails(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "addEmployee";
	}

	
	@RequestMapping("addformsave")
	public String addEmployee(Model model, Employee p) {
		Employee emp = new Employee();
		 emp.setId(p.getId());
		 emp.setFirstName(p.getFirstName());
		 emp.setLastName(p.getLastName());
		 emp.setAge(p.getAge());
		 es.addEmployee(emp);
		 model.addAttribute("employeeDetails", es.getAll());
		 return "redirect:/employees/showAll";
	}

}
