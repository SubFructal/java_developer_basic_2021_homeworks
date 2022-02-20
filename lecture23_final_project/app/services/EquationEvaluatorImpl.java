package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.services;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.EquationEvaluator;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.Currency;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.EvaluationResult;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.InputEquation;

import java.util.List;

public class EquationEvaluatorImpl implements EquationEvaluator {

    private static final List<Integer> LIST_ONE = List.of(1);
    private static final List<Integer> LIST_SEVERAL = List.of(2, 3, 4);
    private static final List<Integer> LIST_MANY = List.of(0, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19);

    @Override
    public EvaluationResult evaluateEquation(InputEquation inputEquation, String equationString) {
        EvaluationResult result;

        String lastTwoCharsSubString = getSubString(equationString);
        int number = parseString(lastTwoCharsSubString);

        if ((result = getResult(LIST_MANY, number, inputEquation, Currency.MANY)) != null) {
            return result;
        } else {
            number %= 10;
        }

        if ((result = getResult(LIST_ONE, number, inputEquation, Currency.ONE)) != null) {
            return result;
        } else if ((result = getResult(LIST_SEVERAL, number, inputEquation, Currency.SEVERAL)) != null) {
            return result;
        } else {
            result = getResult(LIST_MANY, number, inputEquation, Currency.MANY);
        }
        return result;
    }

    private String getSubString(String equationString) {
        String subString;
        try {
            subString = equationString.substring(equationString.length() - 2);
        } catch (IndexOutOfBoundsException e) {
            subString = equationString;
        }
        return subString;
    }

    private int parseString(String string) {
        return Integer.parseInt(string);
    }

    private EvaluationResult getResult(List<Integer> numbers, int number, InputEquation inputEquation,
                                       Currency currency) {
        if (checkNumber(numbers, number)) {
            return new EvaluationResult(inputEquation, currency);
        }
        return null;
    }

    private boolean checkNumber(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }

}
