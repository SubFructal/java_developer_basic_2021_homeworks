package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture6_homework;

/*
Система тестирования
Цель упражнения - получить базовые знания в работе с массивами, циклами, условными операторами и т.д.

Написать систему тестирования.
На экран выводится вопрос и варианты ответа, с клавиатуры вводится номер ответа.
Вопросы и ответы должны быть зашиты в коде, внешнего хранения в файлах или базах данных не нужно.
Должно быть три вопроса, каждый с 3-5 вариантами ответов.
Все вопросы с одним правильным вариантом ответа.
После прохождения теста отображается результат.
Использовать только циклы, массивы, условия и другие структуры, которые были пройдены на данный момент в рамках курса.
В этом задании не нужно использовать ООП.
 */

import java.util.Scanner;

public class TestingSystem {

    public static final String[] QUESTIONS = new String[5];
    public static final String[][] OPTIONS_FOR_QUESTIONS = new String[5][4];
    public static final String[] VALID_ANSWERS = new String[]{"D", "B", "C", "A", "C"};
    public static int validAnswersCount;

    static {
        QUESTIONS[0] = "Какого цвета лента Георгиевского креста, учреждённого в 1807 году?";
        QUESTIONS[1] = "Какой химический элемент назван в честь злого подземного гнома?";
        QUESTIONS[2] = "Кто первым получил Нобелевскую премию по литературе?";
        QUESTIONS[3] = "В какой из этих столиц бывших союзных республик раньше появилось метро?";
        QUESTIONS[4] = "Какой вид кавалерии предназначался для боевых действий как в конном, так и в пешем строю?";

        OPTIONS_FOR_QUESTIONS[0][0] = "Красно-чёрная";
        OPTIONS_FOR_QUESTIONS[0][1] = "Красно-сине-белая";
        OPTIONS_FOR_QUESTIONS[0][2] = "Бело-голубая";
        OPTIONS_FOR_QUESTIONS[0][3] = "Чёрно-оранжевая";

        OPTIONS_FOR_QUESTIONS[1][0] = "Гафний";
        OPTIONS_FOR_QUESTIONS[1][1] = "Кобальт";
        OPTIONS_FOR_QUESTIONS[1][2] = "Бериллий";
        OPTIONS_FOR_QUESTIONS[1][3] = "Теллур";

        OPTIONS_FOR_QUESTIONS[2][0] = "Романист";
        OPTIONS_FOR_QUESTIONS[2][1] = "Драматург";
        OPTIONS_FOR_QUESTIONS[2][2] = "Поэт";
        OPTIONS_FOR_QUESTIONS[2][3] = "Эссеист";

        OPTIONS_FOR_QUESTIONS[3][0] = "Тбилиси";
        OPTIONS_FOR_QUESTIONS[3][1] = "Ереван";
        OPTIONS_FOR_QUESTIONS[3][2] = "Баку";
        OPTIONS_FOR_QUESTIONS[3][3] = "Минск";

        OPTIONS_FOR_QUESTIONS[4][0] = "Кирасиры";
        OPTIONS_FOR_QUESTIONS[4][1] = "Уланы";
        OPTIONS_FOR_QUESTIONS[4][2] = "Драгуны";
        OPTIONS_FOR_QUESTIONS[4][3] = "Гусары";
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            for (int i = 0; i < OPTIONS_FOR_QUESTIONS.length; i++) {
                System.out.println(QUESTIONS[i]);
                for (int j = 0; j < OPTIONS_FOR_QUESTIONS[0].length; j++) {
                    System.out.printf("\t%s: %s\n", Options.values()[j], OPTIONS_FOR_QUESTIONS[i][j]);
                }
                System.out.print("Выберите вариант ответа A, B, C или D и нажмите Enter: ");

                String answer = scanner.nextLine().trim();
                boolean isNonCorrect = true;
                int count = 0;

                while (isNonCorrect) {
                    for (Options answerOption : Options.values()) {
                        if (answer.equalsIgnoreCase(answerOption.toString())) {
                            isNonCorrect = false;
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (count == Options.values().length) {
                        count = 0;
                        System.out.print("Вы ввели некорректные данные." +
                                "Выберите вариант ответа A, B, C или D и нажмите Enter: ");
                        answer = scanner.nextLine().trim();
                    }
                }

                if (answer.equalsIgnoreCase(VALID_ANSWERS[i])) {
                    System.out.println();
                    System.out.println("Поздравляем! Это правильный ответ!\n");
                    validAnswersCount++;
                } else {
                    System.out.println();
                    System.out.println("К сожалению, этот ответ неправильный... Правильный ответ "
                            + VALID_ANSWERS[i] + "\n");
                }
            }
        }
        if (validAnswersCount == VALID_ANSWERS.length) {
            System.out.println("Великолепно! Вы ответили правильно на все вопросы! Тест окончен");
        } else if (validAnswersCount == 0) {
            System.out.println("Да уж... Вы не ответили правильно ни на один вопрос, читайте книги... Тест окончен");
        } else {
            System.out.printf("Тест окончен. Количество правильных ответов: %d", validAnswersCount);
        }
    }

    public enum Options {
        A,
        B,
        C,
        D
    }
}