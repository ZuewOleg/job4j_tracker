package ru.job4j.profession;

public class Programmer extends Engineer {
    private Programmer estimate;

    public Programmer(String name, String surname, String education, String birthday,
                      Drawing drawing, Calculatoin calculatoin, Programmer estimate) {
        super(name, surname, education, birthday, drawing, calculatoin);
        this.estimate = estimate;
    }

    public void estimate(Customer customer) {
        System.out.println("Сделаем сметный расчет");
    }

}
