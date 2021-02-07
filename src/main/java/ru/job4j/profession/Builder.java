package ru.job4j.profession;

public class Builder extends Engineer {
    private Builder build;

    public Builder(String name, String surname, String education, String birthday, Drawing drawing,
                   Calculatoin calculatoin, Builder build) {
        super(name, surname, education, birthday, drawing, calculatoin);
        this.build = build;
    }

    public void build(Customer customer) {
        System.out.println("Мы строим!!!!");
    }

}
