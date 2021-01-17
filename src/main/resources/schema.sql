DROP TABLE IF EXISTS Users;

CREATE TABLE users
(
    id     bigserial NOT NULL,
    name        varchar(50) NOT NULL,
    middlename varchar(50) NOT NULL,
    surname   varchar(50) NOT NULL,
    CONSTRAINT PK_users PRIMARY KEY ( id )
);
