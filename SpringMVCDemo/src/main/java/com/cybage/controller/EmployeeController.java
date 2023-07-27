package com.cybage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.model.Employee;
import com.cybage.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	public ModelAndView getAllEmployees() {
		List<Employee> employeeList = employeeService.getAllEmployees();
		return new ModelAndView("employee", "employees", employeeList);
	}

	@GetMapping("/add")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}

	@PostMapping("/add")
	public ModelAndView addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("addEmployee", "employees", employee);
		}

		employeeService.addEmployee(employee);
		List<Employee> employeeList = employeeService.getAllEmployees();
		return new ModelAndView("employee", "employees", employeeList);
	}

	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable int id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "updateEmployee";
	}

	@PostMapping("/edit")
	public ModelAndView updateEditedEmployee(Model model) {
//		Employee employee = employeeService.getEmployeeById(id);
		Employee e = (Employee) model.getAttribute("employee");
		employeeService.editEmployee(e);
//		model.addAttribute("employee",employee);
		return new ModelAndView("employee", "employees", employeeService.getAllEmployees());
	}

}
