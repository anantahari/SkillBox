package ru.skillbox.demo.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skillbox.demo.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {
    
}
