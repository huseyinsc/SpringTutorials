package com.huseyinsacikay.controller;

import com.huseyinsacikay.dto.DtoCustomer;

public interface ICustomerController {
	public DtoCustomer findCustomerById(Long id);
}
