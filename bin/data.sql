insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Zach', 'Smith', 'abc123', 'zsmith@smoothie.com', '1234567890', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Julie', 'Williams', 'def456', 'jwilliams@smoothie.com', '1234561234', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Sven', 'Bjergson', 'lol123', 'sbjergson@smoothie.com', '1234564321', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Allison', 'Johns', 'password123', 'ajohns@smoothie.com', '1234565566', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Michael', 'Pabst', 'pbr123', 'mpabst@smoothie.com', '1234561289', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('David', 'Anderson', 'dave123', 'danderson@smoothie.com', '1234165346', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Dana', 'Carter', 'fox123', 'dcarter@smoothie.com', '1234162146', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Ashley', 'Weston', 'wes123', 'aweston@smoothie.com', '1234165379', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Jason', 'Fredrick', 'pass123', 'jfredrick@smoothie.com', '1234165346', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Evelynn', 'Rogers', 'eve123', 'erogers@smoothie.com', '1234166269', true);
<<<<<<< HEAD
=======

insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'zsmith@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'jwilliams@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'sbjergson@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'ajohns@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'mpabst@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'danderson@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'dcarter@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'aweston@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'jfredrick@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'erogers@smoothie.com'), 'ADMIN');

insert into java302.shopping_list(user_id, name, color, created_date, modified_date) values ((select id from java302.users where email = 'zsmith@soothie.com'), 'Groceries', 'F00000', 'January 30th, 2016', 'January 31st, 2016');
>>>>>>> 8c5976689b1b69c2c90022be6a96ade273cb09de

insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'zsmith@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'jwilliams@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'sbjergson@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'ajohns@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'mpabst@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'danderson@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'dcarter@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'aweston@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'jfredrick@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'erogers@smoothie.com'), 'ADMIN');

insert into java302.shopping_list(name, color, created_utc, modified_utc, user_id) values ('Groceries', 'F00000', 'January 30th, 2016', 'January 31st, 2016', (select id from java302.users where email = 'zsmith@smoothie.com'));

insert into java302.shopping_list_item(shopping_list_id, contents, priority, created_utc, modified_utc) values((select id from java302.shopping_list where name = 'Groceries'), 'Bacon', '1', 'January 30th, 2016', 'January 31st, 2016');

--insert into java302.notes (shopping_list_item_id, body, created_date, modified_date) values((select id from java302.shopping_list_item where name = 'Bacon'), 'Ekrich Farm', 'January 30th, 2016', 'January 31st, 2016');
