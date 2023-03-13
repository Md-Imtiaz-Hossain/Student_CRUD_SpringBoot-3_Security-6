package com.imtiaz.student_crud_springboot3_security6.repository;

import com.imtiaz.student_crud_springboot3_security6.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByLastName(String lastname);
    
}
