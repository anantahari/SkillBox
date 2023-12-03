package ru.skillbox.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import ru.skillbox.demo.repository.UserRepository;
import ru.skillbox.demo.entity.User;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner demoJpa(UserRepository repository) {
		return (args) -> {
			User vasya = new User("Vasya", "Petrov");
			User petya = new User("Petya", "Ivanov");

			repository.save(vasya);
			repository.save(petya);

			repository.deleteById(1L);

			for (User user: repository.findAll()) {
				System.out.println(user);
			}
		};
	}

}
