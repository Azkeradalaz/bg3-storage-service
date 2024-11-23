package ru.baldursgate3.tgbot.storeservice.services;

import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;

import java.util.List;

public interface GameCharacterService {

    GameCharacter create(GameCharacter newGameCharacter);
    List<GameCharacter> findGameCharactersByTgId(Long tgId);

    GameCharacter getGameCharacter(Long id);

    void updateGameCharacter(GameCharacter gameCharacter);

    void deleteById(Long id);

}
