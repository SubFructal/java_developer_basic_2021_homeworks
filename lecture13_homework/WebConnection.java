package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.util.Random;

public class WebConnection implements AutoCloseable {

    public void connectWithWeb() throws ConnectException {
        boolean isWebConnectionExceptionAvailable = new Random().nextBoolean();
        if (isWebConnectionExceptionAvailable) {
            throw new ConnectException("web connection failed");
        } else {
            System.out.println("web connection is successful");
        }
    }

    public ErrorCodes sendFile(FileWriter fileWriter, int ip, String outputFileName, String fileContent) {
        ErrorCodes res = ErrorCodes.RES_OK;
        try {
            fileWriter.writeFile(outputFileName, fileContent);
        } catch (FileNotFoundException e) {
            res = ErrorCodes.RES_WRONG_FILE_NAME;
        }
        return res;
    }

    @Override
    public void close() throws Exception {

    }
}