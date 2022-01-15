package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture23_final_project;

import java.math.BigInteger;
import java.util.*;

public class FinalProjectFastVersion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Введите пример или exit");

            String s = in.nextLine();


            if (s.equalsIgnoreCase("exit")) {
                break;
            }

            boolean checked = true;
            try {
                if (s.startsWith("+")) {
                    s = new StringBuilder(s).deleteCharAt(0).toString();
                }
                BigInteger bigInteger = new BigInteger(s);
                if (bigInteger.signum() == -1) {
                    checked = false;
                }
            } catch (Exception e) {
                checked = false;
            }

            if (!checked) {
                System.out.println("Неправильный ввод!");
                continue;
            }

            //Разбор примера
            String subS;
            try {
                subS = s.substring(s.length() - 2);
            } catch (IndexOutOfBoundsException e) {
                subS = s;
            }


            String result = new BigInteger(s).abs() + " ";

            List<Integer> list1 = List.of(1);
            List<Integer> list2 = List.of(2, 3, 4);
            List<Integer> list3 = List.of(0, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19);

            int number = Integer.parseInt(subS);

            if (list3.contains(number)) {
                result += "рублей";
                System.out.println(result);
                continue;
            }

            number %= 10;

            if (list1.contains(number)) {
                result += "рубль";
            } else if (list2.contains(number)) {
                result += "рубля";
            } else {
                result += "рублей";
            }

            System.out.println(result);
        }
    }
}