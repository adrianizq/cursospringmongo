package com.escuela.school.service;

import com.escuela.school.model.Course;
import com.escuela.school.model.Student;
import com.escuela.school.repository.CourseRepository;
import com.escuela.school.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;


    public List <Course> getCourses(){
        return courseRepository.findAll();

    }

        public Course getOneCourseById(String id){

        return courseRepository.findById(id).orElse(null);
    }



}
