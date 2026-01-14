package com.huseyinsacikay.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huseyinsacikay.configuration.GlobalProperties;
import com.huseyinsacikay.configuration.Server;

/*
@RestController
@RequestMapping("/rest/api/property")
public class PropertySourceController {
	@Autowired
	private GlobalProperties globalProperties;
	@GetMapping(path = "/datasource")
	public DataSource getDataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setUrl(globalProperties.getUrl());
		dataSource.setUsername(globalProperties.getUsername());
		dataSource.setPassword(globalProperties.getPassword());
		return dataSource;
		
		return null;
	}
}
*/

@RestController
@RequestMapping("/rest/api/property")
public class PropertySourceController {
	@Autowired
	private GlobalProperties globalProperties;
	
	@GetMapping(path = "/servers")
	public List<Server> getServers() {
		System.out.println("Key degeri : " + globalProperties.getKey());
		return globalProperties.getServers();
	}
}