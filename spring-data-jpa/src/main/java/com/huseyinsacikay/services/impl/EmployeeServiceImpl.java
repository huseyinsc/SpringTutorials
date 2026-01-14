package com.huseyinsacikay.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huseyinsacikay.dto.DtoDepartment;
import com.huseyinsacikay.dto.DtoEmployee;
import com.huseyinsacikay.entities.Department;
import com.huseyinsacikay.entities.Employee;
import com.huseyinsacikay.repository.EmployeeRepository;
import com.huseyinsacikay.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public DtoEmployee findEmployeeById(Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		Employee employee = optional.get();
		Department department = employee.getDepartment();
		
		DtoEmployee dtoEmployee = new DtoEmployee();
		DtoDepartment dtoDepartment = new DtoDepartment();
		
		BeanUtils.copyProperties(employee, dtoEmployee);
		BeanUtils.copyProperties(department, dtoDepartment);
		
		dtoEmployee.setDepartment(dtoDepartment);
		return dtoEmployee;
	}

	@Override
	public List<DtoEmployee> findAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<DtoEmployee> dtoEmployees = new ArrayList<>();
		
		if(employees != null && !employees.isEmpty()) {
			for (Employee employee : employees) {
				Department department = employee.getDepartment();
				
				DtoEmployee dtoEmployee = new DtoEmployee();
				DtoDepartment dtoDepartment = new DtoDepartment();
				
				BeanUtils.copyProperties(employee, dtoEmployee);
				BeanUtils.copyProperties(department, dtoDepartment);
				
				dtoEmployee.setDepartment(dtoDepartment);
				dtoEmployees.add(dtoEmployee);
			}
		}
		
		return dtoEmployees;
	}
	
}
