package ru.job4j.profession;

public class Engineer extends Profession {
    private Drawing drawing;
    private Calculatoin calculatoin;

    public void drawing(Customer customer) {
        System.out.println("Чертеж объекта будет готов через месяц");
    }

    public void calculatoin(Customer customer) {
        System.out.println("Стоимость работ составит ...");
    }
}
