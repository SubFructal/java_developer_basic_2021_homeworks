package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.InputEquation;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.services.EquationParserImpl;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.assertions.Assertions;

import java.math.BigInteger;

public class EquationParserImplTest {

    private final EquationParserImpl equationParser = new EquationParserImpl();

    public void testParsingWithPositiveInput() {
        String scenario = "Тест парсинга положительного входящего значения";
        try {
            InputEquation expected = new InputEquation(new BigInteger("127"));
            InputEquation actual = equationParser.parseEquation("127");
            Assertions.assertEquals(expected, actual);

            expected = new InputEquation(new BigInteger("+127"));
            actual = equationParser.parseEquation("+127");
            Assertions.assertEquals(expected, actual);

            expected = new InputEquation(new BigInteger("+000127"));
            actual = equationParser.parseEquation("+000127");
            Assertions.assertEquals(expected, actual);

            expected = new InputEquation(new BigInteger("+000"));
            actual = equationParser.parseEquation("+000");
            Assertions.assertEquals(expected, actual);

            expected = new InputEquation(new BigInteger("+0"));
            actual = equationParser.parseEquation("+0");
            Assertions.assertEquals(expected, actual);

            expected = new InputEquation(new BigInteger("0"));
            actual = equationParser.parseEquation("0");
            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testParsingWithNegativeInput() {
        String scenario = "Тест парсинга отрицательного входящего значения";
        try {
            InputEquation actual = equationParser.parseEquation("-127");
            if (actual != null) {
                throw new AssertionError(String.format("Expected %d = %d", null, actual));
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testParsingWithIncorrectInput() {
        String scenario = "Тест парсинга некорректного входящего значения";
        try {
            InputEquation actual = equationParser.parseEquation("-?%@nm36p++");
            if (actual != null) {
                throw new AssertionError(String.format("Expected %d = %d", null, actual));
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
