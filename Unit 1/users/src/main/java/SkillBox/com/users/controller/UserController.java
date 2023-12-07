package SkillBox.com.users.controller;

import org.springframework.web.bind.annotation.*;
import SkillBox.com.users.entity.Users;
import SkillBox.com.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService usersService;

    public UserController(UserService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    String createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    @GetMapping(path = "/{id}")
    Users getUser(@PathVariable long id) {
        return usersService.getUser(id);
    }

    @PutMapping("/{id}")
    String updateUser(@RequestBody Users user, @PathVariable long id) {
        return usersService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable long id) {
        return usersService.deleteUser(id);
    }

    @GetMapping
    List<Users> getUsers() {
        return usersService.getUsers();
    }
}

