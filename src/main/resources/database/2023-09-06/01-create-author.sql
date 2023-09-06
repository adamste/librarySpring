--liquibase formatted sql
--changeset Adam Stepien:1
create table author
(
    id      serial primary key unique,
    name    varchar(255) not null,
    surname varchar(255) not null,
    country varchar(255)
);

