package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.app;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.app.game.*;

public class Demo {

    public static void main(String[] args) {
        Dice dice = new DiceImpl();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"), new Player("Игорь"));
    }
}
