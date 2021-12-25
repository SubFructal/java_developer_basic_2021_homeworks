package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.tests.unit.fakes;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.app.game.Dice;

public class DiceImplStub implements Dice {
    @Override
    public int roll() {
        return 1;
    }
}