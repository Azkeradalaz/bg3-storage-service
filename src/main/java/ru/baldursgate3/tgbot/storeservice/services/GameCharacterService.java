package ru.baldursgate3.tgbot.storeservice.services;

import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.models.GameCharacterCreateRequest;

import java.util.List;

public interface GameCharacterService {

    GameCharacter create(GameCharacterCreateRequest gameCharacterCreateRequest);
    List<GameCharacter> findGameCharacters();

    void deleteById(Long id);
}
