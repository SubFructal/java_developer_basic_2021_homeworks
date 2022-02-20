package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit.fakes;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.EquationEvaluator;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.Currency;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.EvaluationResult;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.InputEquation;

public class EquationEvaluatorStub implements EquationEvaluator {

    @Override
    public EvaluationResult evaluateEquation(InputEquation inputEquation, String equationString) {
        return new EvaluationResult(inputEquation, Currency.MANY);
    }
}
