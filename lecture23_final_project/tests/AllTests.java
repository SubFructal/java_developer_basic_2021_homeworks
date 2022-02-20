package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit.CommandHandlerImplTest;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit.ConsoleIOServiceTest;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit.EquationEvaluatorImplTest;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit.EquationParserImplTest;

public class AllTests {
    public static void main(String[] args) {
        new ConsoleIOServiceTest().testInput();
        new ConsoleIOServiceTest().testOutput();

        new EquationParserImplTest().testParsingWithPositiveInput();
        new EquationParserImplTest().testParsingWithNegativeInput();
        new EquationParserImplTest().testParsingWithIncorrectInput();

        new EquationEvaluatorImplTest().TestOutputResult();

        new CommandHandlerImplTest().testExitCommandHandler();
        new CommandHandlerImplTest().testHandleEquationCommandWithIncorrectInput();
        new CommandHandlerImplTest().testHandleEquationCommandWithCorrectInput();

    }
}
