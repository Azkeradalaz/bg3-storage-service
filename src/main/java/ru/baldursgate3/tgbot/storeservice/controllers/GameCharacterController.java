package ru.baldursgate3.tgbot.storeservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.entities.User;
import ru.baldursgate3.tgbot.storeservice.models.GameCharacterDto;
import ru.baldursgate3.tgbot.storeservice.models.UserDto;
import ru.baldursgate3.tgbot.storeservice.services.GameCharacterService;
import ru.baldursgate3.tgbot.storeservice.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
public class GameCharacterController {

    private final GameCharacterService gameCharacterService;
    private final UserService userService;

    @PostMapping
    ResponseEntity<String> createGameCharacter(@RequestBody GameCharacterDto newGameCharacter) {

        User user = userService.findByTgId(newGameCharacter.userDto().tgUserId());
        GameCharacter gameCharacter = new GameCharacter();
        gameCharacter.setName(newGameCharacter.name());
        gameCharacter.setUser(user);
        gameCharacter.setStrength(newGameCharacter.strength());
        gameCharacter.setDexterity(newGameCharacter.dexterity());
        gameCharacter.setConstitution(newGameCharacter.constitution());
        gameCharacter.setIntellect(newGameCharacter.intellect());
        gameCharacter.setWisdom(newGameCharacter.wisdom());
        gameCharacter.setCharisma(newGameCharacter.charisma());
        gameCharacterService.create(gameCharacter);
        return new ResponseEntity<>(gameCharacter.getName(), HttpStatus.CREATED);
    }

    @GetMapping("/tgid/{tgId}")
    ResponseEntity<List<GameCharacterDto>> getGameCharacters(@PathVariable Long tgId) {
        List<GameCharacter> gameCharacterList = gameCharacterService.findGameCharactersByTgId(tgId);
        List<GameCharacterDto> gameCharacterDtoList = new ArrayList<>();

        for (GameCharacter gameCharacter : gameCharacterList) {
            gameCharacterDtoList.add(new GameCharacterDto(
                            gameCharacter.getId(),
                            gameCharacter.getName(),
                            new UserDto(gameCharacter.getUser().getName(), gameCharacter.getUser().getTgUserId()),
                            gameCharacter.getStrength(),
                            gameCharacter.getDexterity(),
                            gameCharacter.getConstitution(),
                            gameCharacter.getIntellect(),
                            gameCharacter.getWisdom(),
                            gameCharacter.getCharisma()
                    )
            );

        }

        //todo возвращает всех персов всех пользователей
        return new ResponseEntity<>(gameCharacterDtoList, HttpStatus.OK);
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
