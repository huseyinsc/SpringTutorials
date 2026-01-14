package com.huseyinsacikay.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huseyinsacikay.dto.DtoAddress;
import com.huseyinsacikay.dto.DtoCustomer;
import com.huseyinsacikay.entities.Address;
import com.huseyinsacikay.entities.Customer;
import com.huseyinsacikay.repository.CustomerRepository;
import com.huseyinsacikay.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public DtoCustomer findCustomerById(Long id) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		
		Customer customer = optional.get();
		Address address = customer.getAddress();
		
		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAddress);
		dtoCustomer.setAddress(dtoAddress);
		return dtoCustomer;
	}
	
}
