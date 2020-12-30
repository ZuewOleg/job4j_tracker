package ru.job4j.profession;

public class Builder extends Engineer {
    private Builder build;

    public void build(Customer customer) {
        System.out.println("Мы строим!!!!");
    }
}
