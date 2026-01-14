package com.huseyinsacikay.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.huseyinsacikay.model.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public List<Employee> employeeList(){
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1", "Huseyin", "Sacikay"));
		employeeList.add(new Employee("2", "Burak", "Baytok"));
		employeeList.add(new Employee("3", "Yusuf", "Ergin"));
		employeeList.add(new Employee("4", "Mehmet", "Ibrahimov"));
		employeeList.add(new Employee("5", "Yunis", "Goyushlu"));
		employeeList.add(new Employee("6", "Dunya", "Sacikay"));
		
		return employeeList;
	}
}
