package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle bus = new BusV();
        Vehicle train = new Train();
        Vehicle plane = new Plane();

        Vehicle[] vehicles = new Vehicle[]{bus, train, plane};
        for (Vehicle transport : vehicles) {
            transport.move();
            transport.passengers();
        }
    }
}
