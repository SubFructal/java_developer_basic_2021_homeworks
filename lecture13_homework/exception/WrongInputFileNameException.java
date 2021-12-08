package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework.exception;

import java.io.IOException;

public class WrongInputFileNameException extends IOException {

    public WrongInputFileNameException(String message, Throwable cause) {
        super(message, cause);
    }
}