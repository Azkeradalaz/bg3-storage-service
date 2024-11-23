package ru.baldursgate3.tgbot.storeservice.services;

import ru.baldursgate3.tgbot.storeservice.entities.User;

public interface UserService {
    User save(User user);

    User findById(long userId);

    User findByTgId(Long tgId);
}
