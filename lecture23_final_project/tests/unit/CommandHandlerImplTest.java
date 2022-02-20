package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.CommandHandler;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.EquationEvaluator;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.EquationParser;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.IOService;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.services.CommandHandlerImpl;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.assertions.Assertions;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit.fakes.EquationEvaluatorStub;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit.fakes.EquationParserStub1;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit.fakes.EquationParserStub2;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit.fakes.IOServiceSpy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CommandHandlerImplTest {

    private final List<String> actualFlow = new ArrayList<>();
    private final IOService iOServiceSpy = new IOServiceSpy(actualFlow);

    public void testExitCommandHandler() {
        String scenario = "Тест обработчика команды exit для выхода из приложения";
        try {
            CommandHandler commandHandler = new CommandHandlerImpl(iOServiceSpy, null,
                    null);

            boolean expectedValue = true;
            AtomicBoolean executionFlag = new AtomicBoolean(true);
            String expectedString = "До свидания!";

            boolean actualValue = commandHandler.handleExitCommand("exit", executionFlag);

            Assertions.assertEquals(expectedValue, actualValue);
            Assertions.assertEquals(false, executionFlag.get());
            Assertions.assertEquals(expectedString, actualFlow.get(0));
            Assertions.assertEquals(1, actualFlow.size());

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

    }

    public void testHandleEquationCommandWithIncorrectInput() {
        String scenario = "Тест обработчика входящей строки при невозможном корректном преобразовании строки в число";
        try {
            EquationParser equationParserStub1 = new EquationParserStub1();
            CommandHandler commandHandler = new CommandHandlerImpl(iOServiceSpy, equationParserStub1,
                    null);

            String expectedString = "Неверно введен пример!";

            commandHandler.handleEquationCommand(null);

            Assertions.assertEquals(expectedString, actualFlow.get(0));
            Assertions.assertEquals(1, actualFlow.size());

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testHandleEquationCommandWithCorrectInput() {
        String scenario = "Тест обработчика входящей строки при возможном корректном преобразовании строки в число";
        try {
            EquationParser equationParserStub2 = new EquationParserStub2();
            EquationEvaluator equationEvaluatorStub = new EquationEvaluatorStub();
            CommandHandler commandHandler = new CommandHandlerImpl(iOServiceSpy, equationParserStub2,
                    equationEvaluatorStub);

            String expectedString = "327 рублей";

            commandHandler.handleEquationCommand(null);

            Assertions.assertEquals(expectedString, actualFlow.get(0));
            Assertions.assertEquals(1, actualFlow.size());

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

}
