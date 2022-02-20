package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.services;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.EquationParser;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.InputEquation;

import java.math.BigInteger;

public class EquationParserImpl implements EquationParser {

    @Override
    public InputEquation parseEquation(String equationString) {
        try {
            if (equationString.startsWith("+")) {
                equationString = new StringBuilder(equationString).deleteCharAt(0).toString();
            }
            BigInteger bigInteger = new BigInteger(equationString);
            if (bigInteger.signum() == -1) {
                throw new IllegalArgumentException();
            }
            return new InputEquation(bigInteger);
        } catch (Exception ignored) {
        }
        return null;
    }
}
