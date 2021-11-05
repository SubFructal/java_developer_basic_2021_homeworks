package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture8_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class ConsoleHelper {
	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

	public static void writeMessage(String message) {
		System.out.println(message);
	}

	public static String readString() {
		while (true) {
            try {
                String currentString = BUFFERED_READER.readLine();
                if (currentString != null) {
                    return currentString;
                }
            } catch (IOException e) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }	
	}

	public static void close() throws IOException {
		BUFFERED_READER.close();
	}
}