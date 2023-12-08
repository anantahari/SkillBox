package ru.skillbox.demo.service;

import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import ru.skillbox.demo.entity.User;
import ru.skillbox.demo.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void createUserSuccess() {
        //given
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        User user = new User("Vasya", "Petrov");
        User savedUser = new User(1L, "Vasya", "Petrov");
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
        User user = new User("Vasya", "Petrov");
        User savedUser = new User(1L, "Vasya", "Petrov");
        Mockito.when(userRepository.save(user)).thenThrow(PersistenceException.class);
        UserService userService = new UserService(userRepository);

        //when
        Executable executable = () -> userService.createUser(user);

        //then
        Assertions.assertThrows(PersistenceException.class, executable);
    }
}