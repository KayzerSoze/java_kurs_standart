/*
Нужно написать SQL скрипты.
Создать структур данных в базе. Таблицы. Трансмиссия. Двигатель, Коробка передач.
Создать структуру Машина. Машина не может существовать без данных из первого задания.
*/
--Вывести все машины.

select название, модель From Машины;

--Вывести все неиспользуемые детали.

SELECT кузов as Неиспользуемые_детали FROM Кузова 
EXCEPT 
SELECT кузов FROM Комплектующие_детали JOIN Кузова ON Комплектующие_детали.кузов_компл = Кузова.кузов

union 
SELECT двигатель FROM Двигатели
EXCEPT 
SELECT двигатель FROM Комплектующие_детали JOIN Двигатели ON Комплектующие_детали.двигатель_компл = Двигатели.двигатель

union
SELECT дифференциал FROM Дифференциал 
EXCEPT 
SELECT дифференциал_транссм FROM Трансмиссия JOIN Дифференциал ON Трансмиссия.дифференциал_транссм = Дифференциал.дифференциал

union
SELECT сцепление FROM Сцепление 
EXCEPT 
SELECT сцепление_транссм FROM Трансмиссия JOIN Сцепление ON Трансмиссия.сцепление_транссм = Сцепление.сцепление

union
SELECT тип_коробки FROM Коробки_передач 
EXCEPT 
SELECT коробка_трансм FROM Трансмиссия JOIN Коробки_передач ON Трансмиссия.коробка_трансм = Коробки_передач.тип_коробки;