package ru.baldursgate3.tgbot.storeservice.services;

import ru.baldursgate3.tgbot.storeservice.models.SessionDto;

import java.util.Optional;

public interface SessionService {
    SessionDto getSession(Long userTgId);
    void updateSessionState(Long userTgId, String state);
    void updateSessionGameCharacter(Long userTgId, Optional<Long> gameCharId);

}
