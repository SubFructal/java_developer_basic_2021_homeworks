package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit.fakes;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.EquationParser;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.InputEquation;

import java.math.BigInteger;

public class EquationParserStub2 implements EquationParser {

    @Override
    public InputEquation parseEquation(String equationString) {
        return new InputEquation(new BigInteger("327"));
    }
}
