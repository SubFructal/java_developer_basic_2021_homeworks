package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture3_homework;

import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

// Установить JDK и среду разработки
// Открыть данный класс в IDE
// Скомпилировать данный класс с помощью команды javac.
// Запустить программу на выполнение с помощью команды java
// Запустить программу на выполнение с помощью среды разработки
// Когда программа запросит - введите свое имя латиницей
// Отправить в чат задания скриншоты обоих запусков и строку результата работы программы
public class HomeWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter you full name");
        String fullName = sc.nextLine();
        String encodedFullName = Base64.getEncoder().encodeToString(fullName.getBytes());
        System.out.println("Program result: " + encodedFullName);

        // Добавил дополнительную строку от себя, в тексте ДЗ ее не было
        // Просто стало интересно как кодированную строку декодировать обратно
        try {
            System.out.write(Base64.getDecoder().decode(encodedFullName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}