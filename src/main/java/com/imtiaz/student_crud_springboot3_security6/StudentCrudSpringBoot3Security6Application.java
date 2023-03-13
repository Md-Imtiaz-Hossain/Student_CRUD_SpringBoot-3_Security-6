package com.imtiaz.student_crud_springboot3_security6;

import com.imtiaz.student_crud_springboot3_security6.entity.Course;
import com.imtiaz.student_crud_springboot3_security6.entity.Student;
import com.imtiaz.student_crud_springboot3_security6.entity.User;
import com.imtiaz.student_crud_springboot3_security6.repository.CourseRepository;
import com.imtiaz.student_crud_springboot3_security6.repository.StudentRepository;
import com.imtiaz.student_crud_springboot3_security6.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class StudentCrudSpringBoot3Security6Application {

    public static void main(String[] args) {
        SpringApplication.run(StudentCrudSpringBoot3Security6Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(StudentRepository repository, CourseRepository crepository, UserRepository urepository) {

        return (args) -> {
            // save students
            repository.save(new Student("John", "Johnson", "IT", "john@john.com"));
            repository.save(new Student("Steve", "Stevens", "IT", "steve.stevent@st.com"));

            Stream.of("Programming Java", "Spring Boot basics", "Marketing 1", "Marketing 2").forEach(name -> {
                crepository.save(new Course(name));
            });

            // Create users with BCrypt encoded password (user/user, admin/admin)
            User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
            User user2 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
            urepository.saveAll(Arrays.asList(user1, user2));
        };

    }

}
