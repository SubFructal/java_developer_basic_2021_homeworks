package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework.exception.DatabaseConnectionException;

import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.util.Optional;
import java.util.Random;

public class FileReader implements AutoCloseable {

    public Optional<String> readFile(Database dataBase, String SQLExpression) throws IOException {
        try {
            dataBase.connectWithDatabase();
            String inputFileName = dataBase.readFromDataBase(SQLExpression);
            String inputFileContent = inputFileName + " and input file content";
            boolean isIOExceptionAvailable = new Random().nextBoolean();
            if (isIOExceptionAvailable) {
                throw new IOException();
            }
            return Optional.of(inputFileContent);
        } catch (SQLSyntaxErrorException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public void close() throws Exception {

    }
}