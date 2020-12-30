package ru.job4j.profession;

import javax.tools.Diagnostic;

public class Dentist extends Doctor {
    private Dentist crowns;

    public Dentist(String name, String surname, String education, String birthday, Diagnosis diagnosis, Reception reception, Dentist crowns) {
        super(name, surname, education, birthday, diagnosis, reception);
        this.crowns = crowns;
    }

    public void crows(Dentist crows) {
        System.out.println("Вам золотые или металлокерамику?");
    }

}
