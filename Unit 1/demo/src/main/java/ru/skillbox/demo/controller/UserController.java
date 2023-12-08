package ru.skillbox.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.demo.entity.User;
import ru.skillbox.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Добавление пользователя")
    @PostMapping
    String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @Operation(summary = "Получение пользователя")
    @GetMapping(path = "/{id}")
    User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @Operation(summary = "Обновление пользователя")
    @PutMapping("/{id}")
    String updateUser(@RequestBody User user, @PathVariable long id) {
        return userService.updateUser(user, id);
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

    @Operation(summary = "Получение списка пользователей")
    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

}
