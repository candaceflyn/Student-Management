package com.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;
@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StudentManagementApplication.class, args);
		
		SpringApplication app=new SpringApplication(StudentManagementApplication.class); 
        app.setDefaultProperties(Collections.singletonMap("server.port", 8090));
                app.run(args);
                System.out.println("Application Started...");
	}

}
