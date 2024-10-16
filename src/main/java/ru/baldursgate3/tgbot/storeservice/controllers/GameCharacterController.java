package ru.baldursgate3.tgbot.storeservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.models.GameCharacterCreateRequest;
import ru.baldursgate3.tgbot.storeservice.services.GameCharacterService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gamecharacter")
public class GameCharacterController {

    private final GameCharacterService gameCharacterService;

    @PostMapping
    GameCharacter createGameCharacter(@RequestBody GameCharacterCreateRequest gameCharacterCreateRequest) {

        return gameCharacterService.create(gameCharacterCreateRequest);
    }

    @GetMapping
    List<GameCharacter> getGameCharacters() {
        return gameCharacterService.findGameCharacters();//TODO возвращает все записи вне зависимости от пользователя

    }

//    @PutMapping("/{id}")
//    GameCharacter updateGameCharacter(@RequestBody GameCharacter newGameCharacter, @PathVariable Long id) {
//        return gameCharacterRepository.findById(id)
//                .map(gameCharacter -> {
//                    gameCharacter.setName(gameCharacter.getName());
//                    return gameCharacterRepository.save(gameCharacter);
//                })
//                .orElseGet(() -> gameCharacterRepository.save(newGameCharacter));
//    }
//
//    @DeleteMapping("/{id}")
//    void deleteGameCharacter(@PathVariable Long id) {
//        gameCharacterRepository.deleteById(id);
//    }
//
//    @GetMapping("/{id}")
//    GameCharacter getGameCharacter(@PathVariable Long id) {
//        return gameCharacterRepository.findById(id)
//                .orElseThrow(() -> new GameCharacterNotFoundException(id));
//    }


}
