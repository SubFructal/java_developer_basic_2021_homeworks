package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework.exception.DatabaseConnectionException;

import java.sql.SQLSyntaxErrorException;
import java.util.Random;

public class Database implements AutoCloseable {

    public void connectWithDatabase() throws DatabaseConnectionException {
        boolean isDatabaseConnectionExceptionAvailable = new Random().nextBoolean();
        if (isDatabaseConnectionExceptionAvailable) {
            throw new DatabaseConnectionException("database connection failed");
        } else {
            System.out.println("database connection is successful");
        }
    }

    public String readFromDataBase(String SQLExpression) throws SQLSyntaxErrorException {
        boolean isSQLSyntaxErrorExceptionAvailable = new Random().nextBoolean();
        if (isSQLSyntaxErrorExceptionAvailable) {
            throw new SQLSyntaxErrorException(SQLExpression + ": syntax error in SQL expression");
        }
        return "input file name from database";
    }

    @Override
    public void close() throws Exception {

    }
}