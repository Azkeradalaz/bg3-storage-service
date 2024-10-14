package ru.baldursgate3.tgbot.storeservice.exceptions;

public class GameCharacterNotFoundException extends RuntimeException{
    public GameCharacterNotFoundException(Long id) {
        super("Персонажа с id " + id +" не существует"); //TODO
    }
}
