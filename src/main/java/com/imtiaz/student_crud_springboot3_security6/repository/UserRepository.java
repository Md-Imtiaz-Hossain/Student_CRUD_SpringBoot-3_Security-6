package com.imtiaz.student_crud_springboot3_security6.repository;

import com.imtiaz.student_crud_springboot3_security6.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
    User findByUsername(String username);

}
