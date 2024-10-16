package ru.baldursgate3.tgbot.storeservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.baldursgate3.tgbot.storeservice.entities.User;
import ru.baldursgate3.tgbot.storeservice.services.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

}
