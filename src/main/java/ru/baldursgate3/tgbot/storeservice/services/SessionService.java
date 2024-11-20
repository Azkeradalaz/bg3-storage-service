package ru.baldursgate3.tgbot.storeservice.services;

import ru.baldursgate3.tgbot.storeservice.models.SessionDto;

public interface SessionService {
    SessionDto getSession(Long userTgId);
    void updateSessionState(Long userTgId, String state);

    void updateSessionGameCharacter(Long userTgId, Long gameCharId);

}
