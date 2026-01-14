package com.huseyinsacikay.controller;

import com.huseyinsacikay.dto.DtoAddress;

public interface IAddressController {
	public DtoAddress findAddressById(Long id);
}
