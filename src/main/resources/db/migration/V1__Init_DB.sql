create sequence hibernate_sequence start 1 increment 1;
create table books (
    id int8 not null,
    author varchar(255),
    cover varchar(255),
    description varchar(255),
    isbn varchar(255),
    title varchar(255) not null,
     primary key (id));

create table genre (
    book_id int8 not null,
    genres varchar(255));

create table user_role (
    user_id int8 not null,
    roles varchar(255));

create table usr (
    id int8 not null,
    activation_code varchar(255),
    active boolean not null,
    email varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id));

alter table if exists genre add constraint book_gender_fk foreign key (book_id) references books;
alter table if exists user_role add constraint user_role_fk foreign key (user_id) references usr;

