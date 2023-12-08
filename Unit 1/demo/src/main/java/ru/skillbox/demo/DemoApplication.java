package ru.skillbox.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import ru.skillbox.demo.repository.UserRepository;
import ru.skillbox.demo.entity.User;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

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

			List<User> petrovList = repository.findByLastName("Petrov");

			for (User user: petrovList) {
				System.out.println(user);
				logger.info("log info");
				logger.trace("log trace");
			}

//			repository.deleteById(1L);
//
//			for (User user: repository.findAll()) {
//				System.out.println(user);
//			}
		};
	}

}
