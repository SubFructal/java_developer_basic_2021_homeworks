-- Спроектировать схему базы данных для системы тестирования из
-- занятия "Java синтаксис: массивы, условные операторы, циклы, ДЗ":
-- 1. локально установить PostgreSQL;
-- 2. подготовить нужные DDL-скрипты (CREATE TABLE);
-- 3. Накатить скрипты и убедиться, что достигнут нужный результат.

--CREATE DATABASE otus_homework;

CREATE TABLE valid_answer
(
	id   INTEGER PRIMARY KEY,
    value VARCHAR(5) NOT NULL UNIQUE
);

SELECT * FROM valid_answer;

INSERT INTO valid_answer(id, value)
VALUES
(1, 'A'),
(2, 'B'),
(3, 'C'),
(4, 'D');

CREATE TABLE question
(
    id INTEGER PRIMARY KEY,
    id_valid_answer INTEGER REFERENCES valid_answer (id) ON DELETE CASCADE ON UPDATE CASCADE,
    value  VARCHAR(150) NOT NULL UNIQUE
);

SELECT * FROM question;

INSERT INTO question(id, id_valid_answer, value)
VALUES
(1, 4, 'Какого цвета лента Георгиевского креста, учреждённого в 1807 году?'),
(2, 2, 'Какой химический элемент назван в честь злого подземного гнома?'),
(3, 3, 'Кто первым получил Нобелевскую премию по литературе?'),
(4, 1, 'В какой из этих столиц бывших союзных республик раньше появилось метро?'),
(5, 3, 'Какой вид кавалерии предназначался для боевых действий как в конном, так и в пешем строю?');

CREATE TABLE variant
(
    id INTEGER PRIMARY KEY,
    id_question INTEGER REFERENCES question (id) ON DELETE CASCADE ON UPDATE CASCADE,
    value  VARCHAR(150) NOT NULL
);

SELECT * FROM variant

INSERT INTO variant(id, id_question, value)
VALUES
(1, 1, 'A: Красно-чёрная'),
(2, 1, 'B: Красно-сине-белая'),
(3, 1, 'C: Бело-голубая'),
(4, 1, 'D: Чёрно-оранжевая');

INSERT INTO variant(id, id_question, value)
VALUES
(5, 2, 'A: Гафний'),
(6, 2, 'B: Кобальт'),
(7, 2, 'C: Бериллий'),
(8, 2, 'D: Теллур');

INSERT INTO variant(id, id_question, value)
VALUES
(9, 3, 'A: Романист'),
(10, 3, 'B: Драматург'),
(11, 3, 'C: Поэт'),
(12, 3, 'D: Эссеист');

INSERT INTO variant(id, id_question, value)
VALUES
(13, 4, 'A: Тбилиси'),
(14, 4, 'B: Ереван'),
(15, 4, 'C: Баку'),
(16, 4, 'D: Минск');

INSERT INTO variant(id, id_question, value)
VALUES
(17, 5, 'A: Кирасиры'),
(18, 5, 'B: Уланы'),
(19, 5, 'C: Драгуны'),
(20, 5, 'D: Гусары');


--Создание базы данных закончено
--Теперь делаем различные варианты других операций и выборки из одной и нескольких таблиц

SELECT * FROM valid_answer;
SELECT * FROM question;
SELECT * FROM variant;

--Проверяем ограничения атрибутов в таблицах
INSERT INTO valid_answer (value) VALUES(null);
INSERT INTO valid_answer (value) VALUES('B');

--Проверяем ограничения, которые накладывает внешний ключ
INSERT INTO question(id, id_valid_answer, value)
VALUES(100, 100, 'test');

INSERT INTO variant(id, id_question, value)
VALUES(100, 100, 'test');

--Проверяем корректность свойств внешнего ключа
DELETE FROM valid_answer WHERE id = 4;

--Удаляем все данные из таблиц 
DELETE FROM valid_answer;
DELETE FROM question;
DELETE FROM variant;

--И вставляем данные в таблицы заново, и проверям результат

--Удаляем нужную запись
DELETE FROM variant WHERE id = 20;

--Сортировка по возрастанию
SELECT * FROM variant ORDER BY value;

--То же самое можно так
SELECT * FROM variant ORDER BY value ASC;

--Сортировка по убыванию
SELECT * FROM variant ORDER BY value DESC;

--Фильтрация
SELECT value FROM valid_answer WHERE id > 2;
SELECT * FROM valid_answer;

SELECT * FROM variant WHERE value like 'D%';
SELECT * FROM variant WHERE value like '%: К%';
SELECT * FROM variant WHERE value like '%я';
SELECT * FROM variant;

--JOIN
SELECT * FROM valid_answer;
SELECT * FROM question;
SELECT * FROM variant;

--Декартово произведение (CROSS JOIN)
SELECT v.value AS valid_answer_value, q.value AS question_value
FROM valid_answer AS v
CROSS JOIN question AS q;

SELECT var.id, var.value AS variant_value
FROM variant AS var
JOIN question q ON q.id_valid_answer = var.id ORDER BY var.id DESC;


--UNION
SELECT * FROM valid_answer;
SELECT * FROM question;
SELECT * FROM variant;

SELECT value FROM valid_answer
UNION
SELECT value FROM question;

SELECT 1 AS number_column, value FROM valid_answer
UNION
SELECT 2, value FROM question ORDER BY number_column DESC;

-- Агрегатные функции
SELECT * FROM valid_answer;
SELECT * FROM question;
SELECT * FROM variant;

SELECT COUNT (id) FROM valid_answer;
SELECT COUNT(value) FROM question;
SELECT COUNT(*) FROM variant;


SELECT
    avg(id) avg_id,
    sum(id_valid_answer) sum_id_valid_answer,
    min(value) min_value,
    max(value) max_value
FROM question;





