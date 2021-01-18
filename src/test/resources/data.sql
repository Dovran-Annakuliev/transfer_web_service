insert into users(name, middlename, surname) values ('Ivan', 'Ivanovich', 'Ivanov');
insert into users(name, middlename, surname) values ('Petr', 'Petrovich', 'Petrov');
insert into users(name, middlename, surname) values ('Dmitriy', 'Dvitrievich', 'Dmitrov');

insert into cards(userid, cardnumber, balance) values ('1', '1', '1000');
insert into cards(userid, cardnumber, balance) values ('2', '2', '2000');
insert into cards(userid, cardnumber, balance) values ('3', '3', '3000');

insert into historys(cardid, userid, senderid, recipientid, balance, date) values ('1', '1', '1', '2', '500', '2018-10-20');
insert into historys(cardid, userid, senderid, recipientid, balance, date) values ('1', '1', '1', '3', '1000', '2018-10-21');
insert into historys(cardid, userid, senderid, recipientid, balance, date) values ('3', '3', '3', '1', '2000', '2018-10-22');
