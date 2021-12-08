package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.tests.unit;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.assertions.Assertions;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.app.game.Game;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.app.game.Player;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.tests.unit.fakes.DiceImplSpy;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.tests.unit.fakes.GameWinnerPrinterSpy;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    public void testPlayGame() {
        String scenario = "Тест работы метода playGame() класса Game";
        try {
            List<String> expectedFlow = List.of("Метод roll() вызван впервые с результатом 3 (сыграл Петя)",
                    "Метод roll() вызван второй раз с результатом 4 (сыграл Вася)",
                    String.format("Победитель: %s%n", "Вася"));

            List<String> actualFlow = new ArrayList<>();

            DiceImplSpy diceImplSpy = new DiceImplSpy(actualFlow);
            GameWinnerPrinterSpy gameWinnerPrinterSpy = new GameWinnerPrinterSpy(actualFlow);

            Game game = new Game(diceImplSpy, gameWinnerPrinterSpy);
            game.playGame(new Player("Петя"), new Player("Вася"));

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch(Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}