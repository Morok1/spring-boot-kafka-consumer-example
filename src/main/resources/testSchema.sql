drop table if exists STATEMENT;

create table STATEMENT(
    id identity not null primary key,
    date_value date,
    dater varchar(255) not null,
    value int not null
);


insert into STATEMENT (id, date_value, dater, value) values (1,null, 'ENGINE',1);




