package ru.baldursgate3.tgbot.storeservice.services;

import ru.baldursgate3.tgbot.storeservice.entities.User;

public interface UserService {
    User create(User user);

    User findById(long userId);
}
