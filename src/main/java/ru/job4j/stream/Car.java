package ru.job4j.stream;

public class Car {
    private String marka;
    private String model;
    private int year;
    private double engine;
    private String transmission;
    private int powerhorse;

    static class Builder {
        private String marka;
        private String model;
        private int year;
        private double engine;
        private String transmission;
        private int powerhorse;

        Builder buildMarka(String marka) {
            this.marka = marka;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        Builder buildEngine(double engine) {
            this.engine = engine;
            return this;
        }

        Builder buildTransmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        Builder buildPowerHorse(int door) {
            this.powerhorse = powerhorse;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.marka = marka;
            car.model = model;
            car.year = year;
            car.engine = engine;
            car.transmission = transmission;
            car.powerhorse = powerhorse;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "marka='" + marka + '\''
                + ", model='" + model + '\''
                + ", year=" + year
                + ", engine=" + engine
                + ", transmission='" + transmission + '\''
                + ", powerhorse=" + powerhorse
                + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildMarka("BMW")
                .buildModel("M3")
                .buildYear(2020)
                .buildEngine(5.6)
                .buildTransmission("Auto")
                .buildPowerHorse(350)
                .build();
        System.out.println(car);
    }
}
