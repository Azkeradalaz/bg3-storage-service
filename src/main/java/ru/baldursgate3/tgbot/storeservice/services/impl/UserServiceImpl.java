package ru.baldursgate3.tgbot.storeservice.services.impl;

import org.springframework.stereotype.Service;
import ru.baldursgate3.tgbot.storeservice.entities.User;
import ru.baldursgate3.tgbot.storeservice.repositories.UserRepository;
import ru.baldursgate3.tgbot.storeservice.services.UserService;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}
