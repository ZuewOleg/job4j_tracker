package ru.job4j.poly;

public interface Transport {
    boolean go();

    int passengers();

    int fuel(int price);
}
