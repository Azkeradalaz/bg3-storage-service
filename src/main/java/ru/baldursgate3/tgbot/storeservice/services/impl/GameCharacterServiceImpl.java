package ru.baldursgate3.tgbot.storeservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.models.GameCharacterDto;
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
    public GameCharacter create(GameCharacter gameCharacter) {
        return gameCharacterRepository.save(gameCharacter);
    }

    @Override
    public List<GameCharacterDto> findGameCharactersByTgId(Long tgId) {

        return gameCharacterRepository.findAllByTgId(tgId);
    }

    @Override
    public void deleteById(Long id) {
        gameCharacterRepository.deleteById(id);
    }

}
