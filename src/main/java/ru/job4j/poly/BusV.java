package ru.job4j.poly;

public class BusV implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - driving on the highway");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " - maximum number of passengers : 50");
    }
}
