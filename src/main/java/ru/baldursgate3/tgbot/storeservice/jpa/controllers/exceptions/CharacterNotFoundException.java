package ru.baldursgate3.tgbot.storeservice.jpa.controllers.exceptions;

public class CharacterNotFoundException extends RuntimeException{
    public CharacterNotFoundException(Long id) {
        super("Персонажа с id " + id +" не существует");
    }
}
