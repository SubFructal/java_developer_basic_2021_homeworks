package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain;

import java.math.BigInteger;
import java.util.Objects;

public class InputEquation {

    private final BigInteger equation;

    public InputEquation(BigInteger equation) {
        this.equation = equation;
    }

    public BigInteger getEquation() {
        return equation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputEquation that = (InputEquation) o;
        return equation.equals(that.equation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equation);
    }

    @Override
    public String toString() {
        return equation.toString();
    }
}
