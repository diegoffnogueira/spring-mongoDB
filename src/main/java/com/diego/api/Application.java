package com.diego.api;

import com.diego.api.documents.Cliente;
import com.diego.api.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {

			clienteRepository.deleteAll();

			clienteRepository.save(new Cliente("Alice", 20));
			clienteRepository.save(new Cliente("João", 30));
			clienteRepository.save(new Cliente("Maria", 40));

			System.out.println("Lista todos com o findAll():");
			System.out.println("----------------------------");
			clienteRepository.findAll().forEach(System.out::println);
			System.out.println();

			System.out.println("Busca um único Cliente com o findByName('Alice'):");
			System.out.println("------------------------------------------------");
			System.out.println(clienteRepository.findByNome("Alice"));
			System.out.println();

			System.out.println("Clientes com idades entre 18 e 35 anos:");
			System.out.println("---------------------------------------");
			clienteRepository.findByIdadeBetween(18, 35).forEach(System.out::println);


		};
	}
}
