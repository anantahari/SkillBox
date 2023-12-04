package SkillBox.com.users.repository;

import org.springframework.data.repository.CrudRepository;
import SkillBox.com.users.entity.Users;

import java.util.List;


public interface UserRepository extends CrudRepository<Users, Long> {
    List<Users> findByLastName(String lastName);
}


