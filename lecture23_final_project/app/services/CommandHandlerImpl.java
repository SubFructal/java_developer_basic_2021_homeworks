package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.services;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.CommandHandler;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.EquationEvaluator;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.EquationParser;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.IOService;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.EvaluationResult;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.InputEquation;

import java.util.concurrent.atomic.AtomicBoolean;


public class CommandHandlerImpl implements CommandHandler {

    private static final String EXIT_COMMAND = "exit";

    private final IOService ioService;
    private final EquationParser equationParser;
    private final EquationEvaluator equationEvaluator;


    public CommandHandlerImpl(IOService ioService, EquationParser equationParser, EquationEvaluator equationEvaluator) {
        this.ioService = ioService;
        this.equationParser = equationParser;
        this.equationEvaluator = equationEvaluator;
    }

    @Override
    public boolean handleExitCommand(String command, AtomicBoolean executionFlag) {
        if (!command.equalsIgnoreCase(EXIT_COMMAND)) {
            return false;
        }
        executionFlag.getAndSet(false);
        ioService.outputStr("До свидания!");
        return true;
    }

    @Override
    public void handleEquationCommand(String equationStr) {
        InputEquation inputEquation = equationParser.parseEquation(equationStr);
        if (inputEquation == null) {
            ioService.outputStr("Неверно введен пример!");
            return;
        }

        EvaluationResult solvedEquation = equationEvaluator.evaluateEquation(inputEquation, equationStr);
        ioService.outputStr(solvedEquation.toString());

    }

}
