package com.imtiaz.student_crud_springboot3_security6.repository;

import com.imtiaz.student_crud_springboot3_security6.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long>  {
    
	List<Course> findByName(String name);
}

