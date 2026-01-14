package com.huseyinsacikay.services.impl;

import java.util.Optional;

import org.hibernate.sql.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huseyinsacikay.dto.DtoAddress;
import com.huseyinsacikay.dto.DtoCustomer;
import com.huseyinsacikay.entities.Address;
import com.huseyinsacikay.entities.Customer;
import com.huseyinsacikay.repository.AddressRepository;
import com.huseyinsacikay.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public DtoAddress findAddressById(Long id) {
		DtoAddress dtoAddress = new DtoAddress();
		DtoCustomer dtoCustomer = new DtoCustomer();
		Optional<Address> optional = addressRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		Address address = optional.get();
		Customer customer = address.getCustomer();
		BeanUtils.copyProperties(address, dtoAddress);
		//BeanUtils.copyProperties(customer, dtoCustomer);
		dtoCustomer.setId(customer.getId()); 
		dtoCustomer.setName(customer.getName());
		dtoAddress.setCustomer(dtoCustomer);
		return dtoAddress;
	}
	
}
