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

--SELECT * FROM valid_answer;

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

--SELECT * FROM question;

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

--SELECT * FROM variant

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
