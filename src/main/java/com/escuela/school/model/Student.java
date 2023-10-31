package com.escuela.school.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.beans.Transient;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private Gender gender;

    private Address address;

    private List<String> favouriteSubjects;

    private BigDecimal totalSpentInBooks;

    private LocalDateTime created;

    private ImageData imageData;

    //lista de String para guardar los ids de los cursos
    private List<String> courseIds;

    //Lista de cursos para almacenar temporalmente  los cursos
    @DBRef
    private List<Course> courses;



    public Student(String email, String firstName, String lastName, Gender gender, Address address, List<String> favouriteSubjects, BigDecimal totalSpentInBooks, LocalDateTime created) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.favouriteSubjects = favouriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = created;
    }


}


