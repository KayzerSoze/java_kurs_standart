/*
Нужно написать SQL скрипты.
Создать структур данных в базе. Таблицы. Трансмиссия. Двигатель, Коробка передач.
Создать структуру Машина. Машина не может существовать без данных из первого задания.
*/
--Вывести все машины.

select car_name, model From Cars;

--Вывести все неиспользуемые детали.


SELECT body as Неиспользуемые_детали FROM Car_body
EXCEPT
SELECT body FROM Equipment JOIN Car_body ON Equipment.car_body = Car_body.body

union
SELECT Engine.engine FROM Engine
EXCEPT
SELECT Equipment.engine FROM Equipment JOIN Engine ON Equipment.engine = Engine.engine

union
SELECT differential FROM Differential
EXCEPT
SELECT differential_transm FROM Transmission JOIN Differential ON Transmission.differential_transm = Differential.differential

union
SELECT clutch FROM Clutch
EXCEPT
SELECT clutch_transm FROM Transmission JOIN Clutch ON Transmission.clutch_transm = Clutch.clutch

union
SELECT gearbox FROM Gearbox
EXCEPT
SELECT gearbox_transm FROM Transmission JOIN Gearbox ON Transmission.gearbox_transm = Gearbox.gearbox;