package SkillBox.com.users.service;

import SkillBox.com.users.entity.Users;
import SkillBox.com.users.repository.UserRepository;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void createUserSuccess() {
        //given
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        Users user = new Users("Vasya", "Petrov", "Petrovich", "m", "11.12.1984", "Moscow", "http://ya.ru", "Very good", "Nos", "Developer", "pe@ya.ru", "+71234567890", false);
        Users savedUser = new Users(1L, "Vasya", "Petrov", "Petrovich", "m", "11.12.1984", "Moscow", "http://ya.ru", "Very good", "Nos", "Developer", "pe@ya.ru", "+71234567890", false);
        Mockito.when(userRepository.save(user)).thenReturn(savedUser);
        UserService userService = new UserService(userRepository);

        //when
        String result = userService.createUser(user);

        //then
        Assertions.assertEquals("Пользователь Petrov добавлен в базу с id = 1", result);
    }

    @Test
    void createUserError() {
        //given
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        Users user = new Users("Vasya", "Petrov", "Petrovich", "m", "11.12.1984", "Moscow", "http://ya.ru", "Very good", "Nos", "Developer", "pe@ya.ru", "+71234567890", false);
        Users savedUser = new Users(1L, "Vasya", "Petrov", "Petrovich", "m", "11.12.1984", "Moscow", "http://ya.ru", "Very good", "Nos", "Developer", "pe@ya.ru", "+71234567890", false);
        Mockito.when(userRepository.save(user)).thenThrow(PersistenceException.class);
        UserService userService = new UserService(userRepository);

        //when
        Executable executable = () -> userService.createUser(user);

        //then
        Assertions.assertThrows(PersistenceException.class, executable);
    }

    @Test
    void getUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getUsers() {
    }
}