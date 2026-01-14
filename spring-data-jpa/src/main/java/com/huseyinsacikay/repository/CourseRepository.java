package com.huseyinsacikay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huseyinsacikay.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
