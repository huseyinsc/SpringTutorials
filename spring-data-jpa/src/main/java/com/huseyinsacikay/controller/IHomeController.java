package com.huseyinsacikay.controller;

import com.huseyinsacikay.dto.DtoHome;

public interface IHomeController {
	public DtoHome findHomeById(Long id);
}
