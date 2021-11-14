package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture10_homework;

/*
Домашнее задание
1. Сделать свою реализацию сортировки пузырьком и/или выбором
2. Можно взять другой алгоритм по своему желанию (кроме быстрого)
3. Практически оценить скорость работы в сравнении с Collections.sort
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class AlgorithmsSpeedComparison {

    public static void main(String[] args) {

        ArrayList<Integer> listInteger = new ArrayList<>();
        ArrayList<Double> listDouble = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 1_000; i++) {
            listInteger.add(random.nextInt(10_000));
            listDouble.add(random.nextDouble() * 31);
        }

        System.out.println(listDouble);

        System.out.printf("duration of bubble sort: %d ms\n", getSortDuration(listDouble, SortingType.BUBBLE));
        System.out.printf("duration of selection sort: %d ms\n", getSortDuration(listDouble, SortingType.SELECT));
        System.out.printf("duration of standard sort: %d ms\n", getSortDuration(listDouble, SortingType.STANDARD));

        System.out.println(makeSort(listDouble, SortingType.BUBBLE));
        System.out.println(makeSort(listDouble, SortingType.SELECT));
        System.out.println(makeSort(listDouble, SortingType.STANDARD));

        System.out.println(listDouble);

        System.out.println(listInteger);

        System.out.printf("duration of bubble sort: %d ms\n", getSortDuration(listInteger, SortingType.BUBBLE));
        System.out.printf("duration of selection sort: %d ms\n", getSortDuration(listInteger, SortingType.SELECT));
        System.out.printf("duration of standard sort: %d ms\n", getSortDuration(listInteger, SortingType.STANDARD));

        System.out.println(makeSort(listInteger, SortingType.BUBBLE));
        System.out.println(makeSort(listInteger, SortingType.SELECT));
        System.out.println(makeSort(listInteger, SortingType.STANDARD));

        System.out.println(listInteger);

    }

    public static <T extends Number & Comparable<T>> ArrayList<T> makeSort(ArrayList<T> list, SortingType type) {
        return switch (type) {
            case BUBBLE -> makeBubbleSort(list);
            case SELECT -> makeSelectionSort(list);
            case STANDARD -> makeStandardSort(list);
        };
    }

    public static <T extends Number & Comparable<T>> long getSortDuration(ArrayList<T> list, SortingType type) {
        Date start;
        Date end;

        return switch (type) {
            case BUBBLE -> {
                start = new Date();
                makeBubbleSort(list);
                end = new Date();
                yield end.getTime() - start.getTime();
            }
            case SELECT -> {
                start = new Date();
                makeSelectionSort(list);
                end = new Date();
                yield end.getTime() - start.getTime();
            }
            case STANDARD -> {
                start = new Date();
                makeStandardSort(list);
                end = new Date();
                yield end.getTime() - start.getTime();
            }
        };
    }

    private static <T extends Number & Comparable<T>> ArrayList<T> makeBubbleSort(ArrayList<T> list) {
        list = new ArrayList<>(list);

        for (int i = list.size() - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                T tempCurrent = list.get(j);
                T tempNext = list.get(j + 1);
                if (tempCurrent.compareTo(tempNext) > 0) {
                    list.set(j, tempNext);
                    list.set(j + 1, tempCurrent);
                }
            }
        }

        return list;
    }

    private static <T extends Number & Comparable<T>> ArrayList<T> makeSelectionSort(ArrayList<T> list) {
        list = new ArrayList<>(list);

        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(min)) < 0) {
                    min = j;
                }
            }
            T temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
        }

        return list;
    }

    private static <T extends Number & Comparable<T>> ArrayList<T> makeStandardSort(ArrayList<T> list) {
        list = new ArrayList<>(list);

        Collections.sort(list);

        return list;
    }

}

enum SortingType {
    BUBBLE,
    SELECT,
    STANDARD
}