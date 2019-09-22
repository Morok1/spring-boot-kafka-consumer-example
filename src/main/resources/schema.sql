drop table if exists STATEMENT;

create table STATEMENT(
    id identity not null primary key,
    date_value date ,
    dater varchar(255) not null,
    value int not null
);


insert into STATEMENT (id, date_value, dater, value) values (1,null, 'ENGINE',1);
-- insert into STATEMENT (id, date_value, dater, value) values (2,'2019-11-10', 'ENGINE',2);
-- insert into STATEMENT (id, date_value, dater, value) values (3,'2019-12-10', 'ENGINE',3);
--
-- insert into STATEMENT (id, date_value, dater, value) values (4, '2019-10-11', 'ENGINE',1);
-- insert into STATEMENT (id, date_value, dater, value) values (5, '2019-09-11', 'WHEEL',3);
-- insert into STATEMENT (id, date_value, dater, value) values (6, '2019-08-05', 'WHEEL',2);




