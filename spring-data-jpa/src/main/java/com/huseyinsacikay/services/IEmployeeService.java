package com.huseyinsacikay.services;

import java.util.List;

import com.huseyinsacikay.dto.DtoEmployee;

public interface IEmployeeService {
	public DtoEmployee findEmployeeById(Long id);
	public List<DtoEmployee> findAllEmployees();
}
