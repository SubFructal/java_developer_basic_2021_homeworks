package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.tests.unit.fakes;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.app.game.GameWinnerPrinter;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture16_homework.homework.app.game.Player;

import java.util.List;

public class GameWinnerPrinterSpy implements GameWinnerPrinter {

    private final List<String> actualFlow;

    public GameWinnerPrinterSpy(List<String> actualFlow) {
        this.actualFlow = actualFlow;
    }

    @Override
    public void printWinner(Player winner) {
        actualFlow.add(String.format("Победитель: %s%n", winner.getName()));
    }
}