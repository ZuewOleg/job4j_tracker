package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public boolean go() {
        return true;
    }

    @Override
    public int passengers() {
        return 28;
    }

    @Override
    public int fuel(int price) {
        return 44;
    }
}
