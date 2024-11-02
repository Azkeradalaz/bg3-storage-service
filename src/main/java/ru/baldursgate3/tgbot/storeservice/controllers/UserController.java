package ru.baldursgate3.tgbot.storeservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.entities.User;
import ru.baldursgate3.tgbot.storeservice.models.UserDto;
import ru.baldursgate3.tgbot.storeservice.services.UserService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    ResponseEntity<String> create(@RequestBody UserDto user){
        User newUser = new User();
        newUser.setName(user.name());
        newUser.setTgUserId(user.tgUserId());
        userService.create(newUser);
        return new ResponseEntity<>(newUser.getName(),HttpStatus.CREATED);
    }

    @GetMapping("/tgid/{tgId}")
    ResponseEntity<UserDto> findByTgId(@PathVariable Long tgId){
        User user = null;
        user = userService.findByTgId(tgId);
        UserDto userDto = new UserDto(user.getName(), user.getTgUserId());
        if(user == null){
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(userDto,HttpStatus.OK);
        }

    }
}
