package SkillBox.com.users.service;

import SkillBox.com.users.entity.Users;
import jakarta.persistence.EntityManager;

import SkillBox.com.users.repository.UserRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    public Users create(Users users) {
        return userRepository.save(users);
    }

    public void remove(Long id){
        userRepository.deleteById(id);
    }

    public Iterable<Users> findAll(boolean isDeleted){
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedUserFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<Users> products =  userRepository.findAll();
        session.disableFilter("deletedUserFilter");
        return products;
    }
}
