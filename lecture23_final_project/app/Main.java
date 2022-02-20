package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.CommandHandler;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.EquationEvaluator;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.EquationParser;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.IOService;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.services.*;


public class Main {
    public static void main(String[] args) {
        IOService ioService = new ConsoleIOService(System.out, System.in);
        EquationParser equationParser = new EquationParserImpl();
        EquationEvaluator equationEvaluator = new EquationEvaluatorImpl();
        CommandHandler commandHandler = new CommandHandlerImpl(ioService, equationParser, equationEvaluator);
        ApplicationRunner applicationRunner = new ApplicationRunner(ioService, commandHandler);
        applicationRunner.run();

    }
}
