package ru.job4j.loop;

public class SweetPrice {
    public static void out(int price) {
        int rsl = 0;
        for (int index = 1; index <= 5; index++) {
            rsl = index * price;
            System.out.println(rsl);
        }
    }
}
