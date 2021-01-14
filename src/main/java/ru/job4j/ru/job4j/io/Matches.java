package ru.job4j.ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            int match = 11;
            boolean player = true;
        System.out.println("=== Игра 11 спичек ===");
            while (match > 0) {
                String name = player ? "первого" : "второго";
                System.out.println("Можно взять от 1 до 3 спичек." + System.lineSeparator() + " Ход " + name + " игрока!");
                int user = Integer.valueOf(input.nextLine());
                player = !player;
                if (user < 1 || user > 3) {
                    System.out.println("Можно взять только одну, две или три спички");
                    continue;
                } else {
                    match = match - user;
                }
                System.out.println("Осталось спичек: " + match);
            }
        if (!player) {
            System.out.println("! ! ! Победил первый игрок ! ! !");
            player = false;
        } else {
            System.out.println("! ! ! Победил второй игрок ! ! !");
            player = false;
        }
    }
}

