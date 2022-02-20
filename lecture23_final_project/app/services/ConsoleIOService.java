package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.services;

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project.app.api.services.IOService;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleIOService implements IOService {

    private final PrintStream out;
    private final Scanner in;

    public ConsoleIOService(PrintStream out, InputStream in) {
        this.out = out;
        this.in = new Scanner(in);
    }

    @Override
    public void outputStr(String message) {
        out.println(message);
    }


    @Override
    public String readString() {
        return in.nextLine();
    }

    @Override
    public String readString(String prompt) {
        outputStr(prompt);
        return readString();
    }
}
