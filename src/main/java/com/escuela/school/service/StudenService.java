package com.escuela.school.service;

import com.escuela.school.model.Student;
import com.escuela.school.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudenService {
    private final StudentRepository studentRepository;

    //tipo_retorno nombre_metodo (par1, par2)
    //Obtener la lista de los estudiantes
    public List <Student> getStudents(){
        return studentRepository.findAll();

    }

    public List <Student> getStudentsByFirstName(String name){
        return studentRepository.findByFirstName(name);

    }

    public List <Student> getStudentsByEmail(String email){
        return studentRepository.findByEmail(email);

    }

    public Student getOneStudentById(String id){
        return studentRepository.findById(id).orElse(null);
    }

    //crar un metodo para guardar un nuevo estudiante
    public Student saveStudent(Student student){
        //cuando llega el student no va a tener id

        //antes de guardar el student revisar si el email ya existe
        //si el email no existe, guardamos el nuevo estudiante
        //si el email ya existe, no guardamos al estudiante
        //llamemos al metodo para buscar una lista de estudiantes por su email
        List <Student> studentList = new ArrayList<>();
        studentList = studentRepository.findByEmail(student.getEmail());
        //si la lista tiene elemetos (no es vacia), el email existe
        //si la lista no tiene elementos (es vacia), el email no existe

        if(studentList.size()>0){
            Student s;
            s = studentList.get(0);
            return s;
        }
        //antes de guardar un estudiante darle la fecha de creacion
        student.setCreated(LocalDateTime.now());
        return studentRepository.save(student);
    }
    //Crear un metodo para actualizar un student
    public Student updateStudent(Student student){
        //Actualizar un student, el student debe existir
        //si no existe entonces no hacemos nada retornar un estudiante nulo
        List <Student> studentList = new ArrayList<>();
        studentList = studentRepository.findByEmail(student.getEmail());

        if (studentList.size()>0){ //El student si existe

            Student stTemp = studentList.get(0);
            stTemp.setFirstName(student.getFirstName());
            stTemp.setLastName(student.getLastName());
            stTemp.setAddress(student.getAddress());
            stTemp.setGender(student.getGender());
            stTemp.setFavouriteSubjects(student.getFavouriteSubjects());
            stTemp.setTotalSpentInBooks(student.getTotalSpentInBooks());


            return studentRepository.save(stTemp);
        }
        Student stTemp = new Student();
        return stTemp;
    }

    //Crear un metodo para elminar un student
    public Student deleteStudent(Student student){
        //Para eliminar un student, el student debe exitir

        List <Student> studentList = new ArrayList<>();
        studentList = studentRepository.findByEmail(student.getEmail());
        Student stTemp = new Student();
        if (studentList.size()>0) { //El student si existe
             stTemp = studentList.get(0);
            //elminar el estudiante
            studentRepository.delete(stTemp);
        }
        return stTemp;
    }

}
