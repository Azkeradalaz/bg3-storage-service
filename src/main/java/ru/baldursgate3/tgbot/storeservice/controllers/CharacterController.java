package ru.baldursgate3.tgbot.storeservice.controllers;

import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.controllers.exceptions.GameCharacterNotFoundException;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.repositories.CharacterRepository;

import java.util.List;

@RestController
@RequestMapping("/build")
public class CharacterController {

    private final CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }


    @PostMapping("/create")
    GameCharacter newGameCharacter(@RequestBody GameCharacter newGameCharacter) {

        return newGameCharacter;
    }

    @GetMapping("/all")
    List<GameCharacter> all() {
        return characterRepository.findAll();//TODO возвращает все записи вне зависимости от пользователя

    }

    @PutMapping("/{id}")
    GameCharacter updateGameCharacter(@RequestBody GameCharacter newGameCharacter, @PathVariable Long id) {
        return characterRepository.findById(id)
                .map(gameCharacter -> {
                    gameCharacter.setName(gameCharacter.getName());
                    return characterRepository.save(gameCharacter);
                })
                .orElseGet(() -> characterRepository.save(newGameCharacter));
    }

    @DeleteMapping("/{id}")
    void deleteGameCharacter(@PathVariable Long id) {
        characterRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    GameCharacter getGameCharacter(@RequestParam Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new GameCharacterNotFoundException(id));
    }


}
