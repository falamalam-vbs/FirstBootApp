package com.boot.app.FirstBootApp.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
import com.boot.app.FirstBootApp.service.MyService;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MyController implements ErrorController { // to resolve whitelebel error page

	@Autowired
	private MyService service;
	
//	@RequestMapping(value="/msg",method=RequestMethod.GET)
//	public String greetings() {
//		service.flushCache();
//		return "Welcome";
//	}
//	
//	@RequestMapping(value="/emp",method=RequestMethod.GET,produces="application/json")
//	@ApiResponses(value = {
//	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
//	      /*  @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")*/
//	})
//	public Employee getEmployee() {
//		return service.getEmployee();
//	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully created"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public void createEmployee(@RequestBody (required=false) Employee employee) {
		service.addEmployee(employee);
	}
	
	@RequestMapping(value="/empList",method=RequestMethod.GET,produces= {"application/json","application/xml"})
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retreived"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public List<Employee> getAllEmployees() {
		return service.getEmployees();
	}
	
	@RequestMapping(value="/empByIds",method=RequestMethod.POST,produces="application/json")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully created"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public List<Employee> findEmployeeByIds (@ApiParam(value = "The value of the boolean to set")
	@RequestBody (required=false) Set<String> empIds){
		return service.findEmployeeByIds(empIds);
	}

	@GetMapping("/error")
	public String error() {
		return "Requested Resource is not found !!";
	}
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	@GetMapping("/exc")
	public List<DataAndException> getDatas(){
		DataAndException dataAndException = new DataAndException();
		dataAndException.setName("name");
		dataAndException.setStatus(true);
		dataAndException.setException(new MyException("other"));
		return Arrays.asList(dataAndException);
	}
}
