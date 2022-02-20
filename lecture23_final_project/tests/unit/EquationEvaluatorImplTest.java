package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.EvaluationResult;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.InputEquation;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.services.EquationEvaluatorImpl;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.assertions.Assertions;

import java.math.BigInteger;

public class EquationEvaluatorImplTest {

    private final EquationEvaluatorImpl equationEvaluator = new EquationEvaluatorImpl();

    public void TestOutputResult() {
        String scenario = "Тест правильности выводимого результата работы программы";
        try {
            String expectedString = "101 рубль";
            EvaluationResult actual = equationEvaluator.evaluateEquation(new InputEquation(new BigInteger("101")),
                    "101");
            Assertions.assertEquals(expectedString, actual.toString());

            expectedString = "222 рубля";
            actual = equationEvaluator.evaluateEquation(new InputEquation(new BigInteger("222")), "222");
            Assertions.assertEquals(expectedString, actual.toString());

            expectedString = "555 рублей";
            actual = equationEvaluator.evaluateEquation(new InputEquation(new BigInteger("555")), "555");
            Assertions.assertEquals(expectedString, actual.toString());

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
