package ru.job4j.profession;

import javax.tools.Diagnostic;

public class Dentist extends Doctor {
    private Dentist crowns;

    public void crows(Dentist crows) {
        System.out.println("Вам золотые или металлокерамику?");
    }
}
