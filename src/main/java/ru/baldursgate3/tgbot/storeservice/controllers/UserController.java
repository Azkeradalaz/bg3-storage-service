package ru.baldursgate3.tgbot.storeservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.entities.User;
import ru.baldursgate3.tgbot.storeservice.services.UserService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    ResponseEntity<String> create(@RequestBody User user){
        User newUser = userService.create(user);
        return new ResponseEntity<>(newUser.getName(),HttpStatus.CREATED);
    }

    @GetMapping("/tgid/{tgId}")
    ResponseEntity<User> findByTgId(@PathVariable Long tgId){
        User user = null;
        user = userService.findByTgId(tgId);
        if(user == null){
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(user,HttpStatus.OK);
        }

    }
}
