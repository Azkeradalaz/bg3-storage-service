--liquibase formatted sql

--changeset Mikhail.Rovsha:3
--comment add tg_user_id

alter table tg_user
add tg_user_id bigint;
