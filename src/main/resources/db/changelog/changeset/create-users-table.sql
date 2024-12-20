--liquibase formatted sql

--changeset Mikhail.Rovsha:1
--comment users table initial creation

create table users
(
    id   bigint generated by default as identity primary key,
    name varchar(30) not null
)