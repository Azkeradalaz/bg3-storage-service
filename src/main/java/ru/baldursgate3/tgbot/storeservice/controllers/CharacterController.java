package ru.baldursgate3.tgbot.storeservice.controllers;

import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.controllers.exceptions.CharacterNotFoundException;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.repositories.CharacterRepository;
import ru.baldursgate3.tgbot.storeservice.repositories.UserRepository;

import java.util.List;

@RestController
public class CharacterController {

    private final CharacterRepository characterRepository;

    public CharacterController(UserRepository userRepository, CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }


    @PostMapping("**/build/create")
    GameCharacter newCharacter(@RequestBody GameCharacter newGameCharacter) {
        return newGameCharacter;
    }

    @GetMapping("**/build/all")
    List<GameCharacter> all() {
        return characterRepository.findAll();//TODO возвращает все записи вне зависимости от пользователя

    }

    @PutMapping("**/build/{id}")
    GameCharacter updateCharacter(@RequestBody GameCharacter newGameCharacter, @PathVariable Long id) {
        return characterRepository.findById(id)
                .map(gameCharacter -> {
                    gameCharacter.setName(gameCharacter.getName());
                    return characterRepository.save(gameCharacter);
                })
                .orElseGet(() -> {
                    return characterRepository.save(newGameCharacter);
                });
    }

    @DeleteMapping("**/build/{id}")
    void deleteCharacter(@PathVariable Long id) {
        characterRepository.deleteById(id);
    }

    @GetMapping("**/build/{id}")
    GameCharacter getCharacter(@RequestParam Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }


}
