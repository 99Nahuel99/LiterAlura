package com.aluracursos.literAlura2;

import com.aluracursos.literAlura2.principal.Principal;
import com.aluracursos.literAlura2.repository.AutorRepository;
import com.aluracursos.literAlura2.repository.LibroRepository;
import com.aluracursos.literAlura2.service.ServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAlura2Application implements CommandLineRunner {
	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private ServiceLibro serviceLibro;




	public static void main(String[] args) {
		SpringApplication.run(LiterAlura2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal =new Principal(autorRepository,libroRepository,serviceLibro);
		principal.muestaMenu();

	}
}
