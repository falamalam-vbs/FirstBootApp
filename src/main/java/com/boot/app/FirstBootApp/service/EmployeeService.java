package com.boot.app.FirstBootApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.app.FirstBootApp.model.Employee;
import com.boot.app.FirstBootApp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
}
