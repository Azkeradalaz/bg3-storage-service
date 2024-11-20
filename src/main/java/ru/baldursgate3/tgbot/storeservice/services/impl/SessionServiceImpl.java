package ru.baldursgate3.tgbot.storeservice.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.baldursgate3.tgbot.storeservice.entities.GameCharacter;
import ru.baldursgate3.tgbot.storeservice.entities.Session;
import ru.baldursgate3.tgbot.storeservice.entities.User;
import ru.baldursgate3.tgbot.storeservice.models.SessionDto;
import ru.baldursgate3.tgbot.storeservice.repositories.SessionRepository;
import ru.baldursgate3.tgbot.storeservice.services.GameCharacterService;
import ru.baldursgate3.tgbot.storeservice.services.SessionService;
import ru.baldursgate3.tgbot.storeservice.services.UserService;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Slf4j
@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final UserService userService;
    private final SessionRepository sessionRepository;
    private final GameCharacterService gameCharacterService;


    @Override
    public SessionDto getSession(Long userTgId) {
        User user = userService.findByTgId(userTgId);
        SessionDto result = null;
        if (user == null) {
            user = new User();
            user.setName("default");
            user.setTgUserId(userTgId);
            user = userService.save(user);
        } else {
            Session session = sessionRepository.findByUserId(user.getId());
            if (session == null) {
                session = new Session();
                session.setUser(user);
                session.setState("REGISTER");
                session.setDateCreated(Timestamp.valueOf(LocalDateTime.now()));
                session.setDateExpire(Timestamp.valueOf(LocalDateTime.now()));//todo
                session = sessionRepository.save(session);
            }

            result = new SessionDto(session.getUser().getTgUserId(),
                    session.getGameCharacter()==null ? null : session.getGameCharacter().getId(),
                    session.getState());
        }
        return result;
    }

    @Override
    public void updateSessionState(Long userTgId, String state) {
        Session session = sessionRepository.findByUserId(userTgId);
        session.setState(state);
        sessionRepository.save(session);
        log.info("Сессия изменениа {}", session);
    }

    @Override
    public void updateSessionGameCharacter(Long userTgId, Long gameCharId) {
        Session session = sessionRepository.findByUserId(userTgId);
        GameCharacter gameCharacter = gameCharacterService.getGameCharacter(gameCharId);
        session.setGameCharacter(gameCharacter);
        sessionRepository.save(session);
        log.info("Сессия изменениа {}", session);
    }
}
