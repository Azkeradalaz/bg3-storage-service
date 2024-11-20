package ru.baldursgate3.tgbot.storeservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baldursgate3.tgbot.storeservice.models.SessionDto;
import ru.baldursgate3.tgbot.storeservice.services.SessionService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/session")
public class SessionController {

    private final SessionService sessionService;

    @PutMapping("/{tgId}")
    void updateState(@PathVariable Long tgId, @RequestBody String state) {
        sessionService.updateSessionState(tgId, state);
    }

    @PutMapping({"/gamechar/{tgId}"})
    void updateChar(@PathVariable Long tgId, @RequestBody Long gameCharId){
        sessionService.updateSessionGameCharacter(tgId, gameCharId);
    }

    @GetMapping("/{tgId}")
    ResponseEntity<SessionDto> findByTgId(@PathVariable Long tgId) {
        SessionDto sessionDto = sessionService.getSession(tgId);
        return new ResponseEntity<>(sessionDto, HttpStatus.OK);
    }
}
