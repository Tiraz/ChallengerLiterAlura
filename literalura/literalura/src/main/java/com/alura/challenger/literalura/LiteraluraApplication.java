package com.alura.challenger.literalura;

import com.alura.challenger.literalura.principal.Principal;
import com.alura.challenger.literalura.repositorio.AutorRepository;
import com.alura.challenger.literalura.repositorio.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private AutorRepository repositorio;
	@Autowired
	private LivroRepository livroRepositorio;


	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio, livroRepositorio);
		principal.exibirMenu();
	}
}
