CREATE TABLE Differential(differential VARCHAR(64) PRIMARY KEY);
CREATE TABLE Clutch (clutch VARCHAR(64) PRIMARY KEY);
CREATE TABLE Gearbox (gearbox VARCHAR(64) PRIMARY KEY);
CREATE TABLE Transmission (id serial PRIMARY KEY,
	clutch_transm VARCHAR(64) REFERENCES Clutch(clutch) NOT NULL,
	gearbox_transm VARCHAR(64) REFERENCES Gearbox(gearbox) NOT NULL,
	differential_transm VARCHAR(64) REFERENCES Differential(differential) NOT NULL );

CREATE TABLE Engine (engine VARCHAR(64) PRIMARY KEY);
CREATE TABLE Car_body (body VARCHAR(64) PRIMARY KEY);

CREATE TABLE Equipment (equipment serial PRIMARY KEY,
	Transmission int REFERENCES Transmission(id),
	engine VARCHAR(64) REFERENCES Engine(engine),
	car_body VARCHAR(64) REFERENCES Car_body(body));

CREATE TABLE Cars (id serial PRIMARY KEY, car_name VARCHAR(64), model INTEGER);

CREATE TABLE Cars_equipment (id serial PRIMARY KEY,
	car int REFERENCES Cars(id),
	equipment int REFERENCES Equipment(equipment));

INSERT INTO Differential VALUES ('Самоблокирующийся'),('Принудительно блокируемый'),('Активный'),('Безумный');
INSERT INTO Clutch VALUES ('Однодисковое'),('Двухдисковое'),('Коническое'),('Мертвое');
INSERT INTO Gearbox VALUES ('Механическая'),('Гидромеханическая'),('Планетарная'),('Галактическая'),('Вариаторная');

INSERT INTO Transmission VALUES(1,'Однодисковое', 'Механическая','Самоблокирующийся'),
(2,'Однодисковое', 'Вариаторная','Активный'),(3,'Двухдисковое', 'Гидромеханическая','Самоблокирующийся'),
(4,'Двухдисковое', 'Механическая','Принудительно блокируемый'),(5,'Коническое', 'Механическая','Активный'),
(6,'Коническое', 'Гидромеханическая','Принудительно блокируемый'),(7,'Коническое', 'Вариаторная','Активный');

INSERT INTO Engine VALUES('Паровой'),('Электрический'),('Внутреннего сгорания'),('Лошадь');

INSERT INTO Car_body VALUES('4_дверный'), ('2_дверный'), ('Кабриолет'),('Фанерный');

INSERT INTO Equipment VALUES(1, 1, 'Паровой','4_дверный'),
(2, 2, 'Электрический', '2_дверный'),(3, 1, 'Паровой', '2_дверный'),
(4, 4, 'Электрический','Кабриолет'),(5, 3, 'Паровой', 'Кабриолет'),
(6, 2, 'Электрический','4_дверный');

INSERT INTO Cars VALUES(1, 'Нива', '2101'),(2, 'Нива', '2102'),(3, 'Нива', '2103'),
(4, 'Жигули', '1000'),(5, 'Жигули', '1010'),(6, 'Жигули', '1020'),(7, 'Жигули', '2010'),(8, 'Жигули', '3020'),
(9, 'Волга', '102'),(10, 'Волга', '101'),(11, 'Волга', '103');

INSERT INTO Cars_equipment VALUES(1,1,1),(2,1,2),(3,1,3),(4,2,1),
(5,2,2),(6,2,3),(7,2,4),(8,2,5),(9,3,1),(10,3,2),(11,3,3);

