package com.huseyinsacikay.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huseyinsacikay.dto.DtoCourse;
import com.huseyinsacikay.dto.DtoStudent;
import com.huseyinsacikay.dto.DtoStudentIU;
import com.huseyinsacikay.entities.Course;
import com.huseyinsacikay.entities.Student;
import com.huseyinsacikay.repository.StudentRepository;
import com.huseyinsacikay.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent response = new DtoStudent();
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);
		Student dbStudent = studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response);
		return response;
	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoList = new ArrayList<>();
		List<Student> dbStudents = studentRepository.findAllStudents();
		for (Student student : dbStudents) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			dtoList.add(dtoStudent);
		}
		return dtoList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		Optional<Student> optional = studentRepository.findStudentById(id);
		if(optional.isEmpty()) {
			return null;
		}
		
		Student dbStudent = optional.get();
		List<Course> dbCourses = dbStudent.getCourses();
		
		DtoStudent response = new DtoStudent();
		List<DtoCourse> dtoCourseList = new ArrayList<>();
		
		BeanUtils.copyProperties(dbStudent, response);
		if(dbCourses != null && !dbCourses.isEmpty()) {
			for (Course course : dbCourses) {
				DtoCourse dtoCourse = new DtoCourse();
				BeanUtils.copyProperties(course, dtoCourse);
				dtoCourseList.add(dtoCourse);
			}
		}
		
		response.setCourses(dtoCourseList);
		return response;
	}
	
	@Override
	public void deleteStudent(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU DtoStudentIU) {
		DtoStudent response = new DtoStudent();
		
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			Student dbStudent = optional.get();
			dbStudent.setFirstName(DtoStudentIU.getFirstName());
			dbStudent.setLastName(DtoStudentIU.getLastName());
			dbStudent.setBirthOfDate(DtoStudentIU.getBirthOfDate());
			
			studentRepository.save(dbStudent);
			BeanUtils.copyProperties(dbStudent, response);
			return response;
		}
		return null;
	}
	
}
