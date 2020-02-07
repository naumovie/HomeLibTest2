insert into usr(id, username,password, email,active)
    values (1,'admin','123','ilya.naumov.99@mail.ru', true);


insert into user_role(user_id, roles)
values (1,'ADMIN'), (1,'USER');
