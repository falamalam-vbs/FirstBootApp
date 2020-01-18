package com.boot.app.FirstBootApp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.boot.app.FirstBootApp.model.Employee;

@Service
public class MyService {
	public static final String KEY = "cacheKey";
	private static Map<Integer, Employee> employees = new HashMap<>();

	@Cacheable(value = "cacheName", key = "#root.target.KEY")
	public Employee getEmployee() {
		try {
			System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Employee employee = new Employee();
		employee.setName("Faiyaz");
		employee.setAge("32");
		employee.setAddress("Hzb");
		return employee;
	}

	@CacheEvict(cacheNames = "cacheName", allEntries = true)
	@Scheduled(fixedDelay = 10000)
	public void flushCache() {
	}

	public void addEmployee(Employee emp) {
		employees.putIfAbsent(emp.getId(), emp);
	}

	public List<Employee> getEmployees() {
		return employees.values().stream().collect(Collectors.toList());
	}

	public List<Employee> findEmployeeByIds(Set<String> empIds) {
		return employees.values()
		.stream()
		.filter(e->empIds.contains(e.getId()))
		.collect(Collectors.toList());
	}
}
