package com.escuela.school;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String name;
    private int age;
    private double gpa;
    private boolean fullTime;

    public Student(String email, String name, int age, double gpa, boolean fullTime) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.fullTime = fullTime;
    }

}


