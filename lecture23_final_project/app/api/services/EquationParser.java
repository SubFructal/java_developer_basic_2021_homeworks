package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services;


import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain.InputEquation;

public interface EquationParser {
    InputEquation parseEquation(String equationString);
}
