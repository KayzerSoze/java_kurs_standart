
-- Запросы

--1. Написать запрос получение всех продуктов с типом "СЫР"

SELECT name_product AS продукт FROM products WHERE type_id IN (
          SELECT id FROM types WHERE (type = 'СЫР'));


--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"

SELECT name_product As продукт FROM products WHERE name_product LIKE '%мороженное%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.

SELECT name_product AS продукт, expired_date AS срок_выходит
	FROM products
	WHERE date_part('month',expired_date) = date_part('month',CURRENT_TIMESTAMP)+1
	;

--4. Написать запрос, который вывод самый дорогой продукт.

SELECT name_product, expired_date, price FROM products ORDER BY price DESC LIMIT 1;

--5. Написать запрос, который выводит количество всех продуктов определенного типа.

SELECT type AS тип_продукта, SUM(amount) AS количество
FROM products
JOIN products_amount ON products.id = products_amount.product
JOIN types ON products.type_id = types.id
GROUP BY(types.type);

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"

SELECT type AS тип_продукта, name_product AS продукт,
      expired_date AS срок_годности, price AS цена
FROM products JOIN types ON products.type_id = types.id
WHERE types.type = 'СЫР' OR types.type = 'МОЛОКО';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.

SELECT name_product AS продукт, price AS цена, amount AS количество
FROM products JOIN products_amount
  ON products.id = products_amount.product
WHERE amount < 10
ORDER BY amount ASC;

--8. Вывести все продукты и их тип.

SELECT name_product AS продукт, type AS тип_продукта
FROM types JOIN products ON types.id = products.type_id;