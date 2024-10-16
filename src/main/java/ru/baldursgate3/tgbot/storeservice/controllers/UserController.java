package ru.baldursgate3.tgbot.storeservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.entities.User;
import ru.baldursgate3.tgbot.storeservice.services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    ResponseEntity<User> create(@RequestBody User user){
        User newUser = userService.create(user);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> update(@PathVariable  long id, @RequestBody User user){
        User updateUser = userService.findById(id);
        if (!user.getName().isBlank()) {
            updateUser.setName(user.getName());
        }
        else {
            return new ResponseEntity<>(updateUser,HttpStatus.BAD_REQUEST);
        }
        updateUser = userService.update(updateUser);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }
}
