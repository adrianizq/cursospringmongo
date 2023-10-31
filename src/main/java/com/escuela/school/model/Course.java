package com.escuela.school.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private String id;

    private String name;

    private int hours;



}


