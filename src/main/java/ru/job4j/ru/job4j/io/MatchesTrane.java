package ru.job4j.ru.job4j.io;

import java.util.Scanner;

public class MatchesTrane {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        boolean user = true;
        while (matches > 0) {
            System.out.println("Количество спичек на столе: " + matches);
            System.out.print("Выберите количество спичек от 1 до 3: \n");
            int select = Integer.valueOf(input.nextLine());
            user = !user;
            if (select < 1 || select > 3) {
                System.out.println("Введённое число не соответствует диапазону от 1 до 3\n");
                continue;
            } else {
                matches -= select;
            }
        }
        if (user) {
            System.out.println("Победил первый игрок!");
            user = false;
        } else {
            System.out.println("Победил второй игрок!");
            user = false;
        }
    }
}