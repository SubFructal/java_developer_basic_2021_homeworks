package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework.exception;

import java.io.IOException;

public class EmptyFileContentException extends IOException {

    public EmptyFileContentException(String message) {
        super(message);
    }
}
