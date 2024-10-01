package ru.baldursgate3.tgbot.storeservice.jpa.controllers;

import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.jpa.controllers.exceptions.CharacterNotFoundException;
import ru.baldursgate3.tgbot.storeservice.jpa.entities.Character;
import ru.baldursgate3.tgbot.storeservice.jpa.repositories.CharacterRepository;
import ru.baldursgate3.tgbot.storeservice.jpa.repositories.UserRepository;

import java.util.List;

@RestController
public class CharacterController {

    private final CharacterRepository characterRepository;

    public CharacterController(UserRepository userRepository, CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }


    @PostMapping("**/build/create")
    Character newCharacter(@RequestBody Character newCharacter) {
        return newCharacter;
    }

    @GetMapping("**/build/all")
    List<Character> all() {
        return characterRepository.findAll();//TODO возвращает все записи вне зависимости от пользователя

    }

    @PutMapping("**/build/{id}")
    Character updateCharacter(@RequestBody Character newCharacter, @PathVariable Long id) {
        return characterRepository.findById(id)
                .map(character -> {
                    character.setName(character.getName());
                    return characterRepository.save(character);
                })
                .orElseGet(() -> {
                    return characterRepository.save(newCharacter);
                });
    }

    @DeleteMapping("**/build/{id}")
    void deleteCharacter(@PathVariable Long id) {
        characterRepository.deleteById(id);
    }

    @GetMapping("**/build/{id}")
    Character getCharacter(@RequestParam Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }


}
