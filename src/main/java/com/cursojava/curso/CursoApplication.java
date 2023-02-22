package com.cursojava.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Anotación que indica que esta es una aplicación de Spring Boot
@SpringBootApplication
//Clase principal de la aplicación
public class CursoApplication {
	//Método principal de la aplicación
	public static void main(String[] args) {
		//Inicia la aplicación
		SpringApplication.run(CursoApplication.class, args);
	}

}