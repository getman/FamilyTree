create table person (
    id varchar2(50)),
    first_name varchar2(50),
    last_name varchar2(50),
    birth_day varchar2(50)
);

insert into person values('1', 'Ivan', 'Ivanov', '10.01.1990');
insert into person values('2', 'Petr', 'Petrov', '20.01.1990');
insert into person values('3', 'Stepan', 'Sidorov', '30.01.1990');

commit;