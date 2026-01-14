package com.huseyinsacikay.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huseyinsacikay.controller.IHomeController;
import com.huseyinsacikay.dto.DtoHome;
import com.huseyinsacikay.services.IHomeService;

@RestController
@RequestMapping("/rest/api/home")
public class HomeControllerImpl implements IHomeController{
	@Autowired
	private IHomeService homeService;
	
	@Override
	@GetMapping(path = "/{id}")
	public DtoHome findHomeById(@PathVariable(name = "id") Long id) {
		return homeService.findHomeById(id);
	}
	
}
