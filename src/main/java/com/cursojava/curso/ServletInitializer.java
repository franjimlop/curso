package com.cursojava.curso;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//Servlet que inicializa la aplicación en un servidor web externo
public class ServletInitializer extends SpringBootServletInitializer {
/*El método protegido 'configure()' del ServletInitializer configura la aplicación
  la aplicación y devuelve un objeto 'SpringApplicationBuilder'*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CursoApplication.class);
	}

}
