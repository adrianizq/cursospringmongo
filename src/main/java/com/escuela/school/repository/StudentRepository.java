package com.escuela.school.repository;

import com.escuela.school.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends  MongoRepository <Student, String> {
    List<Student> findByFirstName(String name);
    List<Student> findByEmail(String email);
}
