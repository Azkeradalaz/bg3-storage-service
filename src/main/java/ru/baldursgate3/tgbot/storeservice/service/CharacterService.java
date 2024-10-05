package ru.baldursgate3.tgbot.storeservice.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.baldursgate3.tgbot.storeservice.entities.Character;
import ru.baldursgate3.tgbot.storeservice.repositories.CharacterRepository;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public Character createCharacter(Character character) {
        return characterRepository.save(character);
    }

    public List<Character> getAll() {
       return characterRepository.findAll();
    }
}
