package ru.baldursgate3.tgbot.storeservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.models.GameCharacterCreateRequest;
import ru.baldursgate3.tgbot.storeservice.services.GameCharacterService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
public class GameCharacterController {

    private final GameCharacterService gameCharacterService;

    @PostMapping
    ResponseEntity<GameCharacter> createGameCharacter(@RequestBody GameCharacterCreateRequest gameCharacterCreateRequest) {
        GameCharacter gameCharacter = gameCharacterService.create(gameCharacterCreateRequest);
        return new ResponseEntity<>(gameCharacter, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<GameCharacter>> getGameCharacters() {
        List<GameCharacter> gameCharacterList = gameCharacterService.findGameCharacters();//todo возвращает всех персов всех пользователей
        return new ResponseEntity<>(gameCharacterList,HttpStatus.OK);
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
    @DeleteMapping("/{id}")
    void deleteGameCharacter(@PathVariable Long id) {
        gameCharacterService.deleteById(id);
    }

//    @GetMapping("/{id}")
//    ResponseEntity<GameCharacter> getGameCharacter(@PathVariable Long id) {
//        gameCharacterService.getById();
//    }


}
