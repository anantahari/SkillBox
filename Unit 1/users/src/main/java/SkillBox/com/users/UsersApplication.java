package SkillBox.com.users;

import SkillBox.com.users.entity.Subscribers;
import SkillBox.com.users.entity.Subscriptions;
import SkillBox.com.users.repository.SubscribersRepository;
import SkillBox.com.users.repository.SubscriptionsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import SkillBox.com.users.repository.UserRepository;
import SkillBox.com.users.entity.Users;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@Bean
	CommandLineRunner demoJpa(UserRepository repository) {
		return (args) -> {
			Users vasya = new Users("Vasya", "Petrov", "Petrovich", "m", "11.12.1984", "Moscow", "http://ya.ru", "Very good", "Nos", "Developer", "pe@ya.ru", "+71234567890", false);
			Users petya = new Users("Petya", "Ivanov", "Ivanovich", "m", "11.13.1984", "Moscow", "http://ya.ru", "Very good", "Nos", "Developer", "pe@ya.ru", "+71234567890", false);
			Users vanya = new Users("Vanya", "Sidorov", "Ivanovich", "m", "11.13.1984", "Moscow", "http://ya.ru", "Very good", "Nos", "Developer", "pe@ya.ru", "+71234567890", true);

//			Subscriptions one = new Subscriptions("1", "New", false);

//			Subscribers newone = new Subscribers("1", "1", false);

			repository.save(vasya);
			repository.save(petya);
			repository.save(vanya);

//			repositorySub.save(one);

//			repositorySubs.save(newone);

//			List<Users> petrovList = repository.findByLastName("Petrov");

			for (Users user: repository.findAll()) {
				System.out.println(user);

			}
		};
	}

	@Bean
	CommandLineRunner Subscriptions(SubscriptionsRepository repositorySub) {
		return (args) -> {
			Subscriptions one = new Subscriptions("1", "New", false);

			repositorySub.save(one);

			for (Subscriptions subscription: repositorySub.findAll()) {
				System.out.println(subscription);

			}
		};
	}
	@Bean
	CommandLineRunner Subscribers(SubscribersRepository repositorySubs) {
		return (args) -> {
			Subscribers newone = new Subscribers("1", "1", false);

			repositorySubs.save(newone);

			for (Subscribers subscriber: repositorySubs.findAll()) {
				System.out.println(subscriber);

			}
		};
	}
}
