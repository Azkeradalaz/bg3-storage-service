package ru.baldursgate3.tgbot.storeservice.models;

public record SessionDto(Long userTgId,
                         Long gameCharacterId,
                         String userState) {

}
