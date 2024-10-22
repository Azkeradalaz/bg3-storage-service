package ru.baldursgate3.tgbot.storeservice.services;

import ru.baldursgate3.tgbot.storeservice.entities.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User findById(long userId);

    User update(User updateUser);

    List<User> getUserByTgId(Long tgId);

}
