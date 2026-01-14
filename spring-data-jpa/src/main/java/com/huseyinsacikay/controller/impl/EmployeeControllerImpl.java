package com.huseyinsacikay.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huseyinsacikay.controller.IEmployeeController;
import com.huseyinsacikay.dto.DtoEmployee;
import com.huseyinsacikay.services.IEmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController{
	@Autowired
	private IEmployeeService employeeService;
	
	@Override
	@GetMapping(path = "/{id}")
	public DtoEmployee findEmployeeById(@PathVariable(name = "id") Long id) {
		return employeeService.findEmployeeById(id);
	}

	@Override
	@GetMapping(path = "/list")
	public List<DtoEmployee> findAllEmployees() {
		return employeeService.findAllEmployees();
	}

}
