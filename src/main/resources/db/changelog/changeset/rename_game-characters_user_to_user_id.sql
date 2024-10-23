--liquibase formatted sql

--changeset Mikhail.Rovsha:3
--comment renaming user to user_id in game_character

alter table game_character rename column "user" to user_id;