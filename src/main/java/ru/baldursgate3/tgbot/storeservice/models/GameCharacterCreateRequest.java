package ru.baldursgate3.tgbot.storeservice.models;

public record GameCharacterCreateRequest(long userId,
                                         String name,
                                         short strength,
                                         short dexterity,
                                         short constitution,
                                         short intelligence,
                                         short wisdom,
                                         short charisma) {

}
