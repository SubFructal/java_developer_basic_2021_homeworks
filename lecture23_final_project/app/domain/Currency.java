package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.domain;

public enum Currency {

    ONE("рубль"),
    SEVERAL("рубля"),
    MANY("рублей");

    private String value;

    Currency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
