package com.huseyinsacikay.services;

import com.huseyinsacikay.dto.DtoHome;

public interface IHomeService {
	public DtoHome findHomeById(Long id);
}
