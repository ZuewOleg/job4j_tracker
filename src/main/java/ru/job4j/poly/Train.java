package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - goes by rail");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " - maximum number of passengers : 600");
    }
}
