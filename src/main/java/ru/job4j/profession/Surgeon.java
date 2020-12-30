package ru.job4j.profession;

import javax.tools.Diagnostic;

public class Surgeon extends Doctor {
    private Surgeon operation;

    public Surgeon(String name, String surname, String education, String birthday, Diagnosis diagnosis, Reception reception, Surgeon operation) {
        super(name, surname, education, birthday, diagnosis, reception);
        this.operation = operation;
    }

    public void operation(Pacient pacient) {
         System.out.println("Сестра зажим!!!");
     }

}
