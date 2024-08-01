package com.boot.jpa.dao;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boot.jpa.model.Student;
 
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findStudentsByfName(String fname);
	
	

}