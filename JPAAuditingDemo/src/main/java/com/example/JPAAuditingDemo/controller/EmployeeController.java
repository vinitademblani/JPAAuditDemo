package com.example.JPAAuditingDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAAuditingDemo.model.EmployeeDto;
import com.example.JPAAuditingDemo.model.EmployeeEntity;
import com.example.JPAAuditingDemo.model.InputRequest;
import com.example.JPAAuditingDemo.model.TestDateDto;
import com.example.JPAAuditingDemo.model.TestDateEntity;
import com.example.JPAAuditingDemo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@PostMapping("/addEmployee")
	public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody InputRequest request){
		EmployeeEntity result = null;
		try{
		result = empService.addEmployee(request);
		return new ResponseEntity<EmployeeEntity>(result, HttpStatus.CREATED);}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<EmployeeEntity>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	@PostMapping("/addTest")
	public ResponseEntity<TestDateEntity> addTest(@RequestBody TestDateEntity request){
		TestDateEntity result = null;
		try{
			result = empService.addTestDate(request);
			return new ResponseEntity<TestDateEntity>(result, HttpStatus.CREATED);}
			catch(Exception e){
				e.printStackTrace();
				return new ResponseEntity<TestDateEntity>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	@GetMapping("/test")
	public ResponseEntity<List<TestDateDto>> getAllTest(){
		return new ResponseEntity<List<TestDateDto>>(empService.getAllTest(),HttpStatus.OK);
		
	}
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		return new ResponseEntity<List<EmployeeDto>>(empService.getAllEmployees(),HttpStatus.OK);
	}
}
