package com.huseyinsacikay.controller;

import java.util.List;

import com.huseyinsacikay.dto.DtoEmployee;

public interface IEmployeeController {
	public DtoEmployee findEmployeeById(Long id);
	public List<DtoEmployee> findAllEmployees();
}
