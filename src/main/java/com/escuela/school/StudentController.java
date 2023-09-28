package com.escuela.school;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/students")
@AllArgsConstructor
public class StudentController {
    private final StudenService studenService;

    @GetMapping("/all")
    public ResponseEntity <List<Student>> getAllStudents(){

        return ResponseEntity.ok(studenService.getStudents());
    }

    @GetMapping("/byemail")
    public List<Student> getAllByEmail(@RequestParam("email") String email ){
        return  studenService.getStudentsByEmail(email);
    }

    @GetMapping("/byfirstname")
    public List<Student> getAllByFirstName(@RequestParam("name") String name ){
        return  studenService.getStudentsByFirstName(name);
    }

    @GetMapping("/byid")
    public Student getOneById(@RequestParam("id") String id){
        return studenService.getOneStudentById(id);
    }

    //Metodo para guardar un estudiante POST
    @PostMapping("/save")
    ResponseEntity <Student> saveStudent(@RequestBody Student student ){
        Student s = studenService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }

    //Metodo para actualizar un estudiante PUT
    @PutMapping("/update")
    ResponseEntity <Student> updateStudent(@RequestBody Student student){
        Student s = studenService.updateStudent(student);
        return ResponseEntity.ok(s);
    }

    @DeleteMapping("/delete")
    ResponseEntity <Student> deleteStudent(@RequestBody Student student){
        Student s = studenService.deleteStudent(student);
        return ResponseEntity.ok(s);
    }



}
