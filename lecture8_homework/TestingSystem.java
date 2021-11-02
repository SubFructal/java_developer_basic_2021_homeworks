package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture8_homework;

import java.io.IOException;

/*
Проектирование ООП-модели
Переписать в ООП-стиле задание по разработке программы для тестирования
из занятия "Java синтаксис: массивы, условные операторы, циклы".
Продумать структуру классов и как они будут между собой взаимодействовать (какие будут методы в классах).
*/

public class TestingSystem {

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < OptionsForQuestions.getOptionsForQuestions().length; i++) {
            ConsoleHelper.writeMessage(Questions.getQuestions()[i]);
            for (int j = 0; j < OptionsForQuestions.getOptionsForQuestions()[0].length; j++) {
                ConsoleHelper.writeMessage(String.format("\t%s: %s", OptionsNumbers.values()[j],
                        OptionsForQuestions.getOptionsForQuestions()[i][j]));
            }
            ConsoleHelper.writeMessage("Выберите вариант ответа A, B, C или D и нажмите Enter: ");
            String answer = checkInputFromConsole(ConsoleHelper.readString().trim());
            checkAnswer(answer, i);
        }

        ConsoleHelper.close();
        printResult(ValidAnswers.getValidAnswersCount());

    }

    public static String checkInputFromConsole(String input) {
        int count = 0;

        while (true) {
            for (OptionsNumbers option : OptionsNumbers.values()) {
                if (input.equalsIgnoreCase(option.toString())) {
                    return input;
                } else {
                    count++;
                }
            }
            if (count == OptionsNumbers.values().length) {
                count = 0;
                ConsoleHelper.writeMessage("Некорректный ввод. Введите A, B, C или D и нажмите Enter : ");
                input = ConsoleHelper.readString().trim();
            }
        }
    }

    public static void checkAnswer(String answer, int elementNumberInAnswersArray) {
        if (answer.equalsIgnoreCase(ValidAnswers.getValidAnswers()[elementNumberInAnswersArray])) {
            ConsoleHelper.writeMessage("");
            ConsoleHelper.writeMessage("Поздравляем! Это правильный ответ!\n");
            ValidAnswers.incrementValidAnswersCount();
        } else {
            ConsoleHelper.writeMessage("");
            ConsoleHelper.writeMessage("К сожалению, этот ответ неправильный... Правильный ответ "
                    + ValidAnswers.getValidAnswers()[elementNumberInAnswersArray] + "\n");
        }
    }

    public static void printResult(int validAnswersCount) {
        if (validAnswersCount == ValidAnswers.getValidAnswers().length) {
            ConsoleHelper.writeMessage("Великолепно! Вы ответили правильно на все вопросы! Тест окончен");
        } else if (validAnswersCount == 0) {
            ConsoleHelper.writeMessage("Вы не ответили правильно ни на один вопрос... Тест окончен");
        } else {
            ConsoleHelper
                    .writeMessage(String.format("Тест окончен. Количество правильных ответов: %d", validAnswersCount));
        }
    }
}