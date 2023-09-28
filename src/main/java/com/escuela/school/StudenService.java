package com.escuela.school;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudenService {
    private final StudentRepository studentRepository;

    //tipo_retorno nombre_metodo (par1, par2)
    //Obtener la lista de los estudiantes
    List <Student> getStudents(){
        return studentRepository.findAll();

    }

    List <Student> getStudentsByName(String name){
        return studentRepository.findByName(name);

    }

    List <Student> getStudentsByEmail(String email){
        return studentRepository.findByEmail(email);

    }

    Student getOneStudentById(String id){
        return studentRepository.findById(id).orElse(null);
    }

    //crar un metodo para guardar un nuevo estudiante
    Student saveStudent(Student student){
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
        return studentRepository.save(student);
    }
    //Crear un metodo para actualizar un student
    Student updateStudent(Student student){
        //Actualizar un student, el student debe existir
        //si no existe entonces no hacemos nada retornar un estudiante nulo
        List <Student> studentList = new ArrayList<>();
        studentList = studentRepository.findByEmail(student.getEmail());

        if (studentList.size()>0){ //El student si existe

            Student stTemp = studentList.get(0);
            stTemp.setName(student.getName());
            stTemp.setAge(student.getAge());
            stTemp.setGpa(student.getGpa());
            stTemp.setFullTime(student.isFullTime());

            return studentRepository.save(stTemp);
        }
        Student stTemp = new Student();
        return stTemp;
    }

    //Crear un metodo para elminar un student
    Student deleteStudent(Student student){
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
