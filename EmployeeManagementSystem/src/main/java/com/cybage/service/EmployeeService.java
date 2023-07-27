package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cybage.model.Employee;

@Service
public class EmployeeService {
	List<Employee> empList = new ArrayList<>();

	public List<Employee> getAllEmployees() {

		empList.add(new Employee(1, "Alpha", "Dev", 15000));
		empList.add(new Employee(2, "Bravo", "QA", 16000));
		empList.add(new Employee(3, "Charlie", "Sales", 17000));
		return empList;
	}

	public void addEmployee(Employee employee) {
		empList.add(employee);
	}

	public Employee getEmployeeById(int id) {
		Employee emp = null;
		for (Employee e : empList) {
			if (e.getEmpId() == id) {
				emp = e;
			}
		}
		return emp;
	}

	public void editEmployee(Employee emp) {
		for (Employee e : empList) {
			if (e.getEmpId() == emp.getEmpId()) {
				empList.add(empList.indexOf(e), emp);
			
			}
		}
	
	}
	
	public void deleteEmployee(int id) {
		for(Employee e:empList) {
			if(e.getEmpId()==id) {
				empList.remove(e);
			}
		}
	}
}
