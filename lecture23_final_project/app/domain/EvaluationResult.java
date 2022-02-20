package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain;

public class EvaluationResult {

    private final InputEquation inputEquation;
    private final Currency currency;

    public EvaluationResult(InputEquation inputEquation, Currency currency) {
        this.inputEquation = inputEquation;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return inputEquation.getEquation() + " " + currency.getValue();
    }
}
