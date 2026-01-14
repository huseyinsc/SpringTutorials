package com.huseyinsacikay.services;

import com.huseyinsacikay.dto.DtoCustomer;

public interface ICustomerService {
	public DtoCustomer findCustomerById(Long id);
}
