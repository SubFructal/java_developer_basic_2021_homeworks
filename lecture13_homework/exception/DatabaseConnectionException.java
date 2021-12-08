package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework.exception;

import java.sql.SQLException;

public class DatabaseConnectionException extends SQLException {

    public DatabaseConnectionException(String reason) {
        super(reason);
    }
}