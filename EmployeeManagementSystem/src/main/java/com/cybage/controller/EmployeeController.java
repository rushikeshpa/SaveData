package com.cybage.controller;

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
		return new ModelAndView("employee", "empList", employeeService.getAllEmployees());
	}

	@GetMapping("/add")
	public String getForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}

	@PostMapping("/register")
	public ModelAndView addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("addEmployee", "employee", employee);
		}

		employeeService.addEmployee(employee);
		return new ModelAndView("employee", "empList", employeeService.getAllEmployees());
	}

	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable int id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("emp", employee);
		return "updateEmp";
	}

	@PostMapping("/edit")
	public ModelAndView editEmployee(@Valid @ModelAttribute("emp") Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("updateEmp", "employee", employee);
		}

		employeeService.editEmployee(employee);
		return new ModelAndView("employee", "empList", employeeService.getAllEmployees());
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteEmployee(@PathVariable int id, Model model) {
	 employeeService.deleteEmployee(id);
		return new ModelAndView("employee", "empList", employeeService.getAllEmployees());
	}
}
