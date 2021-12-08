package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.tests.unit;


import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.assertions.Assertions;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.app.game.DiceImpl;

public class DiceImplTest {

    private final DiceImpl dice = new DiceImpl();

    public void testDiceImplForNMoreThan1AndLessThan6() {
        String scenario = "Тест генерации количества очков n в диапазоне от 1 до 6";
        try {
            for (int i = 0; i < 1000000; i++) {
                int diceRollValue = dice.roll();
                boolean actual = diceRollValue >= 1 && diceRollValue <= 6;
                Assertions.assertEquals(true, actual);
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceImplForN1() {
        String scenario = "Тест генерации количества очков n = 1";
        try {
            int diceRollValue = 0;
            for (int i = 0; i < 1000000; i++) {
                diceRollValue = dice.roll();
                if (diceRollValue != 1) {
                    continue;
                }
                break;
            }
            Assertions.assertEquals(1, diceRollValue);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceImplForN2() {
        String scenario = "Тест генерации количества очков n = 2";
        try {
            int diceRollValue = 0;
            for (int i = 0; i < 1000000; i++) {
                diceRollValue = dice.roll();
                if (diceRollValue != 2) {
                    continue;
                }
                break;
            }
            Assertions.assertEquals(2, diceRollValue);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceImplForN3() {
        String scenario = "Тест генерации количества очков n = 3";
        try {
            int diceRollValue = 0;
            for (int i = 0; i < 1000000; i++) {
                diceRollValue = dice.roll();
                if (diceRollValue != 3) {
                    continue;
                }
                break;
            }
            Assertions.assertEquals(3, diceRollValue);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceImplForN4() {
        String scenario = "Тест генерации количества очков n = 4";
        try {
            int diceRollValue = 0;
            for (int i = 0; i < 1000000; i++) {
                diceRollValue = dice.roll();
                if (diceRollValue != 4) {
                    continue;
                }
                break;
            }
            Assertions.assertEquals(4, diceRollValue);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceImplForN5() {
        String scenario = "Тест генерации количества очков n = 5";
        try {
            int diceRollValue = 0;
            for (int i = 0; i < 1000000; i++) {
                diceRollValue = dice.roll();
                if (diceRollValue != 5) {
                    continue;
                }
                break;
            }
            Assertions.assertEquals(5, diceRollValue);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceImplForN6() {
        String scenario = "Тест генерации количества очков n = 6";
        try {
            int diceRollValue = 0;
            for (int i = 0; i < 1000000; i++) {
                diceRollValue = dice.roll();
                if (diceRollValue != 6) {
                    continue;
                }
                break;
            }
            Assertions.assertEquals(6, diceRollValue);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

}