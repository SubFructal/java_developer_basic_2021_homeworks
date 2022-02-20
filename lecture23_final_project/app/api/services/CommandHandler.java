package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services;

import java.util.concurrent.atomic.AtomicBoolean;

public interface CommandHandler {

    boolean handleExitCommand(String command, AtomicBoolean executionFlag);

    void handleEquationCommand(String equationStr);
}
