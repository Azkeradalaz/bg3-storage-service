package ru.baldursgate3.tgbot.storeservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.entities.User;
import ru.baldursgate3.tgbot.storeservice.models.GameCharacterCreateRequest;
import ru.baldursgate3.tgbot.storeservice.repositories.GameCharacterRepository;
import ru.baldursgate3.tgbot.storeservice.services.GameCharacterService;
import ru.baldursgate3.tgbot.storeservice.services.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameCharacterServiceImpl implements GameCharacterService {

    private final UserService userService;
    private final GameCharacterRepository gameCharacterRepository;

    @Override
    public GameCharacter create(GameCharacterCreateRequest gameCharacterCreateRequest) {
        User user = userService.findById(gameCharacterCreateRequest.userId());

        GameCharacter newGameCharacter = new GameCharacter();
        newGameCharacter.setUser(user);
        newGameCharacter.setName(gameCharacterCreateRequest.name());
        newGameCharacter.setStrength(gameCharacterCreateRequest.strength());
        newGameCharacter.setDexterity(gameCharacterCreateRequest.dexterity());
        newGameCharacter.setConstitution(gameCharacterCreateRequest.constitution());
        newGameCharacter.setIntellect(gameCharacterCreateRequest.intelligence());
        newGameCharacter.setWisdom(gameCharacterCreateRequest.wisdom());
        newGameCharacter.setCharisma(gameCharacterCreateRequest.charisma());

        return gameCharacterRepository.save(newGameCharacter);
    }

    @Override
    public List<GameCharacter> findGameCharacters() {
        return gameCharacterRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        gameCharacterRepository.deleteById(id);
    }

}
