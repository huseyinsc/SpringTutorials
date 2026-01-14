package com.huseyinsacikay.services;

import com.huseyinsacikay.dto.DtoAddress;

public interface IAddressService {
	public DtoAddress findAddressById(Long id);
}
