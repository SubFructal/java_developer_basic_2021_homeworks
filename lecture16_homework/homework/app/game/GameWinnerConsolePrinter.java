package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.app.game;

public class GameWinnerConsolePrinter implements GameWinnerPrinter {
    @Override
    public void printWinner(Player winner) {
        System.out.printf("Победитель: %s%n", winner.getName());
    }
}
