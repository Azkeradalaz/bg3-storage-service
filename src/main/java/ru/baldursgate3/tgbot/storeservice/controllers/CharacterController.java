package ru.baldursgate3.tgbot.storeservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.controllers.exceptions.CharacterNotFoundException;
import ru.baldursgate3.tgbot.storeservice.entities.Character;

import java.util.List;
import ru.baldursgate3.tgbot.storeservice.service.CharacterService;

@RestController
@RequestMapping("/build")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @PostMapping("/create")
    Character newCharacter(@RequestBody Character newCharacter) {
        return characterService.createCharacter(newCharacter);
    }

    @GetMapping("/all")
    List<Character> all() {
        return ;//TODO возвращает все записи вне зависимости от пользователя

    }

    @PutMapping("/{id}")
    Character updateCharacter(@RequestBody Character newCharacter, @PathVariable Long id) {
        return characterRepository.findById(id)
                .map(character -> {
                    character.setName(character.getName());
                    return characterRepository.save(character);
                })
                .orElseGet(() -> characterRepository.save(newCharacter));
    }

    @DeleteMapping("/{id}")
    void deleteCharacter(@PathVariable Long id) {
        characterRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    Character getCharacter(@PathVariable  Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }


}
