package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.IOService;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.services.ConsoleIOService;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.assertions.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleIOServiceTest {

    public void testInput() {
        String scenario = "Тест чтения строки";
        try {
            String expected = "input string";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(expected.getBytes());
            IOService ioService = new ConsoleIOService(null, inputStream);
            String actual = ioService.readString();
            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testOutput() {
        String scenario = "Тест вывода строки";
        try {
            String expected = "output string";
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            IOService ioService = new ConsoleIOService(new PrintStream(outputStream),
                    new ByteArrayInputStream(new byte[0]));
            ioService.outputStr(expected);
            String actual = outputStream.toString();
            Assertions.assertEquals(expected + System.getProperty("line.separator"), actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
