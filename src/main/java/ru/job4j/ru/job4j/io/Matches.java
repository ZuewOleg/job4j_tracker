package ru.job4j.ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Игра 11 спичек");
            System.out.println("1. Правила игры");
            System.out.println("2. Играть");
            System.out.println("3. Выйти");
            int select = Integer.valueOf(input.nextLine());
            if (select == 3) {
                System.out.println("Good Bye");
                run = false;
            } else if (select == 1) {
                System.out.println("Смысл игры в следующем. На столе лежат 11 спичек. " +
                        "Два игрока по очереди берут от 1 до 3 спичек. " +
                        "Выигрывает тот, кто забрал последние спички."
                );
            } else if (select == 2) {
                boolean game = true;
                while (game) {
                    int  match = 11;
                    while (match > 0) {
                        System.out.println("Ход первого игрока. Можно взять от 1 до 3 спичек");
                        int player1 = Integer.valueOf(input.nextLine());
                            match = match - player1;
                            System.out.println("Осталось спичек: " + match);
                            if (match == 0) {
                                System.out.println("Победил первый игрок");
                                break;
                            }
                        System.out.println("Ход второго игрока. Можно взять от 1 до 3 спичек");
                        int player2 = Integer.valueOf(input.nextLine());
                            match = match - player2;
                            System.out.println("Осталось спичек: " + match);
                            if (match == 0) {
                                System.out.println("Победил второй игрок");
                                break;
                            }
                    }
                    if (match == 0) {
                        System.out.println("Сыграем еще раз?");
                        game = false;
                    }
                }
            }
        }
    }
}
