package com.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbootdemo.model.Employee;
import com.springbootdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService es;

	@RequestMapping("/showAll")
	public String showAllEmployee(Model model) {
		model.addAttribute("employeeDetails", es.getAllEmployee());
		return "viewEmployeeDetails";
	}

	@RequestMapping("/addEmployee")
	public String addEmpolyeeDetails(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "addEmployee";
	}

	@RequestMapping("addformsave")
	public String addEmployee(Model model, Employee emp) {
		es.addEmployee(emp);
		return "redirect:/employees/showAll";
	}

	@RequestMapping("/removeEmployee")
	public String removeEmpolyeeDetails() {
		return "removeEmployee";
	}

	@RequestMapping("/removeOnSave")
	public String removeEmpolyeeDetails(@RequestParam("empId") String id) {
		if (es.employeeExists(id)) {
			es.deleteEmployee(Integer.parseInt(id));
			return "redirect:/employees/showAll";
		}
		return null;
	}

}
