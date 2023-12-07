package SkillBox.com.users.repository;

import SkillBox.com.users.entity.Subscribers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SubscribersRepository extends CrudRepository<Subscribers, Long> {
    List<Subscribers> findAll();
}
