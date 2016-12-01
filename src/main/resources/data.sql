insert into java302.shopping_list(user_id, name, color, created_date, modified_date) values ((select id from java302.users where email = 'zsmith@soothie.com'), 1001, 'Groceries', 'F00000', 'January 30th, 2016', 'January 31st, 2016');

insert into java302.shopping_list_item(shopping_list_id, contents, priority, created_date, modified_date) values((select id from java302.shopping_list where name = 'Groceries'), 'Bacon', '1', 'January 30th, 2016', 'January 31st, 2016');

insert into java302.notes (shopping_list_item_id, body, created_date, modified_date) values((select id from java302.shopping_list_item where name = 'Bacon'), 'Ekrich Farm', 'January 30th, 2016', 'January 31st, 2016');
