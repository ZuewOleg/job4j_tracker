package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - flying through the air");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " - maximum number of passengers : 400");
    }
}
