package ru.baldursgate3.tgbot.storeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.models.GameCharacterDto;

import java.util.List;

public interface GameCharacterRepository extends JpaRepository<GameCharacter, Long> {


    @Query(value = "select gc from game_character gc where user_id = ?1", nativeQuery = true)
    List<GameCharacterDto> findAllByTgId(Long tgId);
}
