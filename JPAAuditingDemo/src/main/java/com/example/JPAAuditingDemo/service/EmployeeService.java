package com.example.JPAAuditingDemo.service;

import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPAAuditingDemo.model.EmployeeDto;
import com.example.JPAAuditingDemo.model.EmployeeEntity;
import com.example.JPAAuditingDemo.model.InputRequest;
import com.example.JPAAuditingDemo.model.TestDateDto;
import com.example.JPAAuditingDemo.model.TestDateEntity;
import com.example.JPAAuditingDemo.repository.EmployeeRepository;
import com.example.JPAAuditingDemo.repository.TestDateRepository;
import com.example.JPAAuditingDemo.util.ObjectMapperUtils;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	TestDateRepository testRepo;
	public EmployeeEntity addEmployee(InputRequest request){
		String curretUser = request.getLoggedInUser();
		EmployeeEntity emp = request.getEmployee();
		emp.setCreatedBy(curretUser);
		EmployeeEntity result = empRepo.save(emp);
		
		return result;
	}
	
	public TestDateEntity addTestDate(TestDateEntity req){
		TestDateEntity result = testRepo.save(req);
		return result;
	}
	public List<EmployeeDto> getAllEmployees(){
		
		List<EmployeeEntity> result = empRepo.findAll();
		System.out.println(result.get(0).getCreatedDate().atZone(ZoneId.of("America/New_York")).toLocalDate());
		List<EmployeeDto> list = ObjectMapperUtils.mapAll(result, EmployeeDto.class);
		return list;
	}
	public List<TestDateDto> getAllTest(){
		List<TestDateEntity> result =  testRepo.findAll();
		List<TestDateDto> list =ObjectMapperUtils.mapAll(result, TestDateDto.class);
		return list;
	}
}
