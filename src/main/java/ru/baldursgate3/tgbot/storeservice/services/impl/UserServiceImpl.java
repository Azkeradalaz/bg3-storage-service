package ru.baldursgate3.tgbot.storeservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ru.baldursgate3.tgbot.storeservice.entities.User;
import ru.baldursgate3.tgbot.storeservice.exceptions.UserNotFoundException;
import ru.baldursgate3.tgbot.storeservice.repositories.UserRepository;
import ru.baldursgate3.tgbot.storeservice.services.UserService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("Пользователь с id:" + userId + " не существует.")
        );
    }

    @Override
    public User update(User updateUser) {
        User user = findById(updateUser.getId());
        user.setName(updateUser.getName());
        return userRepository.save(updateUser);
    }

    @Override
    public List<User> getUserByTgId(Long tgId) {
        return userRepository.findUserByTgID(tgId);
    }

}
