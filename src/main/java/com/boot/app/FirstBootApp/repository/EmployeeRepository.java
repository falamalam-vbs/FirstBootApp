package com.boot.app.FirstBootApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.app.FirstBootApp.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
