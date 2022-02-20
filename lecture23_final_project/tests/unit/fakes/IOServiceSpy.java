package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.tests.unit.fakes;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.IOService;

import java.util.List;

public class IOServiceSpy implements IOService {

    private final List<String> actualFlow;

    public IOServiceSpy(List<String> actualFlow) {
        this.actualFlow = actualFlow;
    }

    @Override
    public void outputStr(String message) {
        actualFlow.add(message);
    }

    @Override
    public String readString() {
        return null;
    }

    @Override
    public String readString(String prompt) {
        return null;
    }
}
