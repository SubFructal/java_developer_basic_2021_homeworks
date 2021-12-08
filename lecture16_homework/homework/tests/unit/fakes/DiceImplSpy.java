package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.tests.unit.fakes;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.app.game.Dice;

import java.util.List;

public class DiceImplSpy implements Dice {

    private boolean isFirstInputCall = true;
    private final List<String> actualFlow;

    public DiceImplSpy(List<String> actualFlow) {
        this.actualFlow = actualFlow;
    }

    @Override
    public int roll() {
        actualFlow.add("Метод roll() вызван " +
                (isFirstInputCall ? "впервые с результатом 3 (сыграл Петя)" : "второй раз с результатом 4 (сыграл Вася)"));

        // Если вызывали метод в первый раз, то считаем, что ожидается результат 3
        if (isFirstInputCall) {
            isFirstInputCall = false;
            return 3;
        }
        // Если вызывали метод во второй раз, то считаем, что ожидается результат 4
        return 4;
    }
}
