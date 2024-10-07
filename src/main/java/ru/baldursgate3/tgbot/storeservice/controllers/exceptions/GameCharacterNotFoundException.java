package ru.baldursgate3.tgbot.storeservice.controllers.exceptions;

public class GameCharacterNotFoundException extends RuntimeException{
    public GameCharacterNotFoundException(Long id) {
        super("Персонажа с id " + id +" не существует");
    }
}
