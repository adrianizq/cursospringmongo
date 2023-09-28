package com.escuela.school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SchoolApplication {

	public static void main(String[] args) {

		SpringApplication.run(SchoolApplication.class, args);
	}
	//insertar un nuevo documento student en la base de datos school
	//inyectando el repositorio de student

	//@Bean
	//CommandLineRunner runner (StudentRepository studentRepository,
	//						  MongoTemplate mongoTemplate){
	//	return args -> {
			//crear un objeto student llamando al constructor sin el id
	//		Student student = new Student(
	//				"Carmen",
	//				23,
	//				3.5,
	//				true
	//		);
			//recuperar un estudiante por su id
			/*Optional <Student> st= studentRepository.findById("64f0e75eb9baf72ea1facbf2");
			System.out.println(st.get().getName());
			System.out.println(st.get().getAge());
			System.out.println(st.get().getGpa());*/

			//recuperar una lista de todos los estudiantes
			//List <Student> studentList = studentRepository.findAll();
			//for(Student s :  studentList){
			//	System.out.println(s.getName());
			//	System.out.println(s.getAge());
			//	System.out.println(s.getGpa());
			//}

			//Borrar un documento, primero debemos encontrar ese objeto, luego borrar
			//Optional <Student> st= studentRepository.findById("64f0e4d8b9baf72ea1facbf0");
			//studentRepository.delete(st.get());

			//Modificar un documento, primero debemos buscar ese objeto, modificarlo y guardar
			//Optional <Student> st= studentRepository.findById("64f0e4d8b9baf72ea1facbf0");
			//st.get().setName("Bob Esponja");
			//st.get().setAge(31);
			//studentRepository.save(st.get());*/
			//Query query = new Query();
			//query.addCriteria(Criteria.where("name").is("Patrick"));
			//List <Student> list = mongoTemplate.find(query, Student.class);

			//for (Student s:list){
			//	System.out.println(s.getName());
			//	System.out.println(s.getAge());
			//	System.out.println(s.getGpa());
			//}



			//studentRepository.insert(student);
		//};

	//}


}
