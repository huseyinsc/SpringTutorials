package com.huseyinsacikay.controller;

import java.util.List;

import com.huseyinsacikay.dto.DtoStudent;
import com.huseyinsacikay.dto.DtoStudentIU;

public interface IStudentController {
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	public List<DtoStudent> getAllStudents();
	public DtoStudent getStudentById(Integer id);
	public void deleteStudent(Integer id);
	public DtoStudent updateStudent(Integer id, DtoStudentIU DtoStudentIU);
}

