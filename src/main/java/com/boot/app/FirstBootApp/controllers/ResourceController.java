package com.boot.app.FirstBootApp.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.app.FirstBootApp.exception.MyException;
import com.boot.app.FirstBootApp.model.DataAndException;
import com.boot.app.FirstBootApp.model.Employee;
import com.boot.app.FirstBootApp.service.EmployeeService;
import com.boot.app.FirstBootApp.service.MyService;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/resource")
public class ResourceController { 

	@Autowired
	private EmployeeService service;

	@RequestMapping(value="/add",method=RequestMethod.POST,produces= {"application/json","application/xml"})
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retreived"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public Employee addEmployee( @Valid @RequestBody Employee emp) {
		return service.addEmployee(emp);
	}
}
