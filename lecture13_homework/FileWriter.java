package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework;

import java.io.FileNotFoundException;
import java.util.Random;

public class FileWriter implements AutoCloseable {

    public String writeFile(String outputFileName, String fileContent) throws FileNotFoundException {
        boolean isFileNotFoundAvailable = new Random().nextBoolean();
        if (isFileNotFoundAvailable) {
            throw new FileNotFoundException();
        }
        return outputFileName + " " + fileContent;
    }

    @Override
    public void close() throws Exception {

    }
}