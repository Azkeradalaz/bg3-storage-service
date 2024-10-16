--liquibase formatted sql

--changeset Mikhail.Rovsha:2
--comment renaming gamecharacters to game_character

alter table gamecharacters rename to game_character;