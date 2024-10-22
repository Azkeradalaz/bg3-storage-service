package ru.baldursgate3.tgbot.storeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.baldursgate3.tgbot.storeservice.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select t.id,t.name,t.tg_user_id from tg_user t where t.tg_user_id = ?1", nativeQuery = true)
    List<User> findUserByTgID(Long tgId);

}
