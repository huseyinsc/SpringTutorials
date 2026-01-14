package com.huseyinsacikay.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huseyinsacikay.controller.IAddressController;
import com.huseyinsacikay.dto.DtoAddress;
import com.huseyinsacikay.services.IAddressService;

@RestController
@RequestMapping("/rest/api/address")
public class AdressControllerImpl implements IAddressController{
	@Autowired
	private IAddressService addressService;

	@Override
	@GetMapping(path = "/list/{id}")
	public DtoAddress findAddressById(@PathVariable(name = "id") Long id) {
		return addressService.findAddressById(id);
	}
	
}
