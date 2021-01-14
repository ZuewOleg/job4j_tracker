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
                    int match = 11;
                    boolean player = true;
                    while (match > 0) {
                        String name = player ? "первого" : "второго";
                        System.out.println("Можно взять от 1 до 3 спичек." + " Ход " + name + " игрока!");
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
                    if (match == 0) {
                        if (!player) {
                            System.out.println("! ! ! Победил первый игрок ! ! !");
                            System.out.println();
                            System.out.println("Сыграем еще?");
                            System.out.println();
                            game = false;
                        } else {
                            System.out.println("! ! ! Победил второй игрок ! ! !");
                            System.out.println();
                            System.out.println("=== Сыграем еще? ===");
                            System.out.println();
                            game = false;
                        }
                    }
                }
            }
        }
    }
}

