package ru.baldursgate3.tgbot.storeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.entities.Session;
import ru.baldursgate3.tgbot.storeservice.models.GameCharacterDto;
import ru.baldursgate3.tgbot.storeservice.models.SessionDto;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    @Query(value = "select s.id, " +
            "s.user_id," +
            "s.game_character_id," +
            "s.state," +
            "s.date_created," +
            "s.date_expire from session s where user_id = ?1", nativeQuery = true)
    Session findByUserId(Long tgId);
}
