package ru.baldursgate3.tgbot.storeservice.controllers;

import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.controllers.exceptions.GameCharacterNotFoundException;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.repositories.GameCharacterRepository;

import java.util.List;

@RestController
@RequestMapping("build")
public class GameCharacterController {

    private final GameCharacterRepository gameCharacterRepository;

    public GameCharacterController(GameCharacterRepository gameCharacterRepository) {
        this.gameCharacterRepository = gameCharacterRepository;
    }


    @PostMapping("/create")
    GameCharacter newGameCharacter(@RequestBody GameCharacter newGameCharacter) {

        return newGameCharacter;//todo service
    }

    @GetMapping("/all")
    List<GameCharacter> all() {
        return gameCharacterRepository.findAll();//TODO возвращает все записи вне зависимости от пользователя

    }

    @PutMapping("/{id}")
    GameCharacter updateGameCharacter(@RequestBody GameCharacter newGameCharacter, @PathVariable Long id) {
        return gameCharacterRepository.findById(id)
                .map(gameCharacter -> {
                    gameCharacter.setName(gameCharacter.getName());
                    return gameCharacterRepository.save(gameCharacter);
                })
                .orElseGet(() -> gameCharacterRepository.save(newGameCharacter));
    }

    @DeleteMapping("/{id}")
    void deleteGameCharacter(@PathVariable Long id) {
        gameCharacterRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    GameCharacter getGameCharacter(@PathVariable Long id) {
        return gameCharacterRepository.findById(id)
                .orElseThrow(() -> new GameCharacterNotFoundException(id));
    }


}
