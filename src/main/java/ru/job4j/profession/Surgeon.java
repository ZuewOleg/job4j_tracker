package ru.job4j.profession;

import javax.tools.Diagnostic;

public class Surgeon extends Doctor {
    private Surgeon operation;

     public void operation(Pacient pacient) {
         System.out.println("Сестра зажим!!!");
     }

}
