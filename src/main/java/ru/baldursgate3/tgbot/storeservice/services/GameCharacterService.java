package ru.baldursgate3.tgbot.storeservice.services;

import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.models.GameCharacterDto;

import java.util.List;

public interface GameCharacterService {

    GameCharacter create(GameCharacter newGameCharacter);
    List<GameCharacterDto> findGameCharactersByTgId(Long tgId);

    void deleteById(Long id);

}
