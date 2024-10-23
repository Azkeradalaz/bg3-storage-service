--liquibase formatted sql

--changeset Mikhail.Rovsha:2
--comment renaming users to user

alter table bg3buildsdb.public.users rename to tg_user;