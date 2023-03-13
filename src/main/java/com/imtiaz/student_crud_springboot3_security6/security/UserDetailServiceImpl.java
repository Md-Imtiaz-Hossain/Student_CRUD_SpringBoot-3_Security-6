package com.imtiaz.student_crud_springboot3_security6.security;

import com.imtiaz.student_crud_springboot3_security6.entity.User;
import com.imtiaz.student_crud_springboot3_security6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public UserDetailServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = repository.findByUsername(username);
        UserBuilder builder = null;
        if (currentUser == null) {
            throw new UsernameNotFoundException("User not found.");
        } else {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(currentUser.getPasswordHash());
            builder.roles(currentUser.getRole());
        }
        return builder.build();
    }

}