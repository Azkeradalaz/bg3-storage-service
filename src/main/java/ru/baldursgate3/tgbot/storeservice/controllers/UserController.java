package ru.baldursgate3.tgbot.storeservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.entities.User;
import ru.baldursgate3.tgbot.storeservice.models.UserDto;
import ru.baldursgate3.tgbot.storeservice.services.UserService;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    ResponseEntity<String> create(@RequestBody UserDto user){
        User newUser = new User();
        String userName = user.name();
        if(userName.length()>30){
            userName = userName.substring(0,30);
        }
        newUser.setName(userName);
        newUser.setTgUserId(user.tgUserId());
        userService.save(newUser);
        return new ResponseEntity<>(newUser.getName(),HttpStatus.CREATED);
    }

    @GetMapping("/tgid/{tgId}")
    ResponseEntity<UserDto> findByTgId(@PathVariable Long tgId){
        User user = userService.findByTgId(tgId);
        if(user == null){
            return new ResponseEntity<>(null,HttpStatus.OK);
        }else {
            UserDto userDto = new UserDto(user.getName(), user.getTgUserId());
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
    }

    @PutMapping("/tgid/{tgId}")
    void updateUser(@PathVariable Long tgId, @RequestBody Optional<String> nameOpt){
        User user = userService.findByTgId(tgId);
        String name = nameOpt.get();
        name = name.replace("\"", "");
        if(name.length()>30){
            name = name.substring(0,30);
        }
        user.setName(name);
        userService.save(user);
    }
}
