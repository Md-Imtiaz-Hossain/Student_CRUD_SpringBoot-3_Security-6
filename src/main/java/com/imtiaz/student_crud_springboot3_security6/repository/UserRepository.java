package com.imtiaz.student_crud_springboot3_security6.repository;

import java.util.Optional;

import com.imtiaz.student_crud_springboot3_security6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);
}