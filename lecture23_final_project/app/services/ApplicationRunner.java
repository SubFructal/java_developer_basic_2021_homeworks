package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.services;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.CommandHandler;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.IOService;

import java.util.concurrent.atomic.AtomicBoolean;

public class ApplicationRunner {

    private final IOService ioService;
    private final CommandHandler commandHandler;

    public ApplicationRunner(IOService ioService, CommandHandler commandHandler) {
        this.ioService = ioService;
        this.commandHandler = commandHandler;
    }

    public void run() {
        AtomicBoolean executionFlag = new AtomicBoolean(true);

        while (executionFlag.get()) {
            String commandOrEquation = showPromptAndReadCommand();

            if (!commandHandler.handleExitCommand(commandOrEquation, executionFlag)) {
                commandHandler.handleEquationCommand(commandOrEquation);
            }
        }
    }

    private String showPromptAndReadCommand() {
        return ioService.readString("Введите число или exit для выхода из программы");
    }
}
