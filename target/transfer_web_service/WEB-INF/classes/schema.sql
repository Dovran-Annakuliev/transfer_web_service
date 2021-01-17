DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    userid     bigserial NOT NULL,
    name        varchar(50) NOT NULL,
    middlename varchar(50) NOT NULL,
    surname   varchar(50) NOT NULL,
    CONSTRAINT PK_users PRIMARY KEY ( userid )
);

DROP TABLE IF EXISTS cards;

CREATE TABLE cards
(
    cardid     bigserial NOT NULL,
    userid     bigint NOT NULL,
    cardnumber bigserial NOT NULL,
    balance     real NOT NULL,
    CONSTRAINT PK_cards PRIMARY KEY ( cardid, userid ),
    CONSTRAINT FK_11 FOREIGN KEY ( userid ) REFERENCES users ( userid )
);

CREATE INDEX fkIdx_12 ON cards
(
    userid
);

DROP TABLE IF EXISTS history;

CREATE TABLE history
(
    historyid     bigserial NOT NULL,
    cardid        bigint NOT NULL,
    userid        bigint NOT NULL,
    senderid      bigint NOT NULL,
    recipientid   bigint NOT NULL,
    balance        real NOT NULL,
    operationtype varchar(50) NOT NULL,
    "date"           date NOT NULL,
    CONSTRAINT PK_history PRIMARY KEY ( historyid, cardid, userid ),
    CONSTRAINT FK_19 FOREIGN KEY ( cardid, userid ) REFERENCES cards ( cardid, userid )
);

CREATE INDEX fkIdx_20 ON history
(
    cardid,
    userid
);
