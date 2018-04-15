/**
postgres> CREATE DATABASE system_item

*/
CREATE TABLE roles (
	id serial PRIMARY KEY,
	user_role VARCHAR(32)
);

--Таблица прав Rules типа READ, WRITE, CHANGE
CREATE TABLE rules (
	id serial PRIMARY KEY,
	name_rules VARCHAR(32)
);

--Таблица связи таблиц ролей и прав
CREATE TABLE roles_rules (
	role_id serial,
	rules_id serial,
	PRIMARY KEY(role_id, rules_id),
	FOREIGN KEY (role_id) REFERENCES roles(id),
	FOREIGN KEY (rules_id) REFERENCES rules(id)
);

--Таблица пользователей
CREATE TABLE users (
	id serial PRIMARY KEY,
	user_name VARCHAR (20),
	user_mail VARCHAR (30),
	user_role int REFERENCES roles(id)
);

--Таблица Категорий заявок
CREATE TABLE categories (
	id serial PRIMARY KEY,
	category_item VARCHAR (20)
);

--Таблица Состояния заявок
CREATE TABLE states (
	id serial PRIMARY KEY,
	state_item VARCHAR (30)
);

--Таблица заявок
CREATE TABLE items (
	id serial PRIMARY KEY REFERENCES users(id),
	item VARCHAR (30),
	item_category int REFERENCES categories(id),
	item_state int REFERENCES states(id)
);
--Таблица комментов к заявкам
CREATE TABLE comments (
	id SERIAL PRIMARY KEY,
	comment VARCHAR,
	comment_item int REFERENCES items(id)
);

--Таблица прикрепленных файлов к заявкам
CREATE TABLE attaches (
	id SERIAL PRIMARY KEY,
	file_path VARCHAR(200),
	item_attach int REFERENCES items(id)
);

--Заполняем начальные данные
--Права - создание, чтение, обновление, удаление.
INSERT INTO rules VALUES(1, 'create'),(2, 'read'),(3, 'update'),(4,'delete');

--Роли
INSERT INTO roles VALUES(1,'root'),(2,'user'),(3,'guest');

--Отношение ролей и прав
INSERT INTO roles_rules VALUES
(1,1),(1,2),(1,3),(1,4),(2,2),(2,3),(3,2);

--Три пробных пользователя
INSERT INTO users VALUES(1, 'user_1', 'mail_1', 1),
(2, 'user_2', 'mail_2', 2),(3, 'user_3', 'mail_3', 3);

--Категирии заявок - срочно, не срочно, совсем не срочно
INSERT INTO categories VALUES(1,'urgent'),(2,'not urgent'),(3,'not urgent at all');

--Состояние - готово, не готово
INSERT INTO states VALUES(1,'ready'),(2,'not ready');

--Три пробные заявки
INSERT INTO items VALUES(1,'item_1', 1, 2),
(2,'item_2', 3, 2),(3,'item_3', 1, 1);

--Пробные комментарии
INSERT INTO comments VALUES(1, 'comment_1', 1),(2, 'comment_2', 1),
(3, 'comment_1', 2),(4, 'comment_1', 3);

--Прикрепленные файлы хранятся в ввиде пути к файлу
INSERT INTO attaches VALUES(1, 'file_path', 1),(2, 'file_path', 2),
(3, 'file_path', 3);