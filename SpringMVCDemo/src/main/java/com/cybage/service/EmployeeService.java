package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cybage.dao.EmployeeRepository;
import com.cybage.model.Employee;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;

	private List<Employee> employeeList = null;

	public EmployeeService() {
		employeeList = new ArrayList<Employee>();
		this.employeeList.add(new Employee(1, "Sonam", "Manager", 45000.00));
		this.employeeList.add(new Employee(2, "Roop", "Sr Manager", 50000.00));
		this.employeeList.add(new Employee(3, "Ishant", "Sr Engineer", 32000.00));
		this.employeeList.add(new Employee(4, "Dan", "Manager", 50000.00));
		this.employeeList.add(new Employee(5, "Sam", "Sr Engineer", 50000.00));
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
		
	}

	public void addEmployee(Employee employee) {
		
		employeeRepository.save(employee);
	}

	public Employee getEmployeeById(int id) {
		employeeRepository.findAllById(ids);

	}

	public Employee editEmployee(Employee employee) {

		for (Employee emp : this.employeeList) {
			if (emp.getId() == employee.getId()) {
				employee = emp;
				break;
			}
		}
		return employee;

	}

}
