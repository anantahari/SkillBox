package SkillBox.com.users.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import SkillBox.com.users.entity.Users;
import SkillBox.com.users.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(Users user) {
        Users savedUser = userRepository.save(user);
        return String.format("Пользователь %s добавлен в базу с id %s ", savedUser.getLastName(), savedUser.getId());
    }

    public Users getUser(long id) {
        return userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String updateUser(Users user, long id) {
        if(!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Users savedUser = userRepository.save(user);

        return String.format("Пользователь %s успешно сохранен", savedUser.getLastName());
    }

    public String deleteUser(long id) {
        if(!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        userRepository.deleteById(id);

        return String.format("Пользователь с id = %s успешно удален", id);
    }


    public List<Users> getUsers() {
        return userRepository.findAll();
    }
}
