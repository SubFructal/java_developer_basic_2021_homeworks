package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.tests;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.tests.unit.DiceImplTest;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.tests.unit.GameTest;

public class AllTests {
    public static void main(String[] args) {

        new DiceImplTest().testDiceImplForNMoreThan1AndLessThan6();
        new DiceImplTest().testDiceImplForN1();
        new DiceImplTest().testDiceImplForN2();
        new DiceImplTest().testDiceImplForN3();
        new DiceImplTest().testDiceImplForN4();
        new DiceImplTest().testDiceImplForN5();
        new DiceImplTest().testDiceImplForN6();

        new GameTest().testPlayGame();

    }

}