package ru.baldursgate3.tgbot.storeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.baldursgate3.tgbot.storeservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
