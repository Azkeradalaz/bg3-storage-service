package ru.baldursgate3.tgbot.storeservice.models;

public record GameCharacterDto(String name,
                               UserDto userDto,
                               short strength,
                               short dexterity,
                               short constitution,
                               short intellect,
                               short wisdom,
                               short charisma) {
}
