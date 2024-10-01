package ru.baldursgate3.tgbot.storeservice.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.baldursgate3.tgbot.storeservice.jpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
