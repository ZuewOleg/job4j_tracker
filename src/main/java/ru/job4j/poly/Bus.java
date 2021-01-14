package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public boolean go() {
        return true;

    }

    @Override
    public int passengers() {
        int passengers = 28;
        return passengers;
    }

    @Override
    public int fuel(int price) {
        price = 44;
        return price;
    }
}
