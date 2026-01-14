package com.huseyinsacikay.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huseyinsacikay.model.Employee;
import com.huseyinsacikay.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {
	@Autowired
	private List<Employee> employeeList;
	
	public List<Employee> getAllEmployeeList(){
		return employeeList;
	}
	
	public Employee getEmployeeById(String id){
		Employee foundEmployee = null;
		for (Employee employee : employeeList) {
			if(id.equals(employee.getId())) {
				foundEmployee = employee;
			}
		}
		
		return foundEmployee;
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
		List<Employee> foundEmployeeList = new ArrayList<>();
		
		boolean firstEmpty = firstName.isEmpty(), lastEmpty = lastName.isEmpty();
		
		if(firstEmpty && lastEmpty) {
			return employeeList;
		}
		else if(!firstEmpty && !lastEmpty) {
			for (Employee employee : employeeList) {
				if(firstName.equalsIgnoreCase( employee.getFirstName() ) && lastName.equalsIgnoreCase( employee.getLastName() )) {
					foundEmployeeList.add(employee);
					break;
				}
			}
		}
		else if(!firstEmpty || !lastEmpty) {
			for (Employee employee : employeeList) {
				if(firstName.equalsIgnoreCase( employee.getFirstName() ) || lastName.equalsIgnoreCase( employee.getLastName() )) {
					foundEmployeeList.add(employee);
				}
			}
		}
		
		return foundEmployeeList;
	}
	
	public Employee saveEmployee(Employee newEmployee){
		employeeList.add(newEmployee);
		return newEmployee;
	}
	
	public boolean deleteEmployee(String id){
		boolean success = false;
		for (Employee employee : employeeList) {
			if(id.equals(employee.getId())) {
				employeeList.remove(employee);
				success = true;
				break;
			}
		}
		
		return success;
	}
	
	public Employee updateEmployee(String id, UpdateEmployeeRequest request){
		Employee foundEmployee = null;
		for (Employee employee : employeeList) {
			if(id.equals(employee.getId())) {
				employee.setFirstName(request.getFirstName());
				employee.setLastName(request.getLastName());
				foundEmployee = employee;
				break;
			}
		}
		
		return foundEmployee;
	}
}
