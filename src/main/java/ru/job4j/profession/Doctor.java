package ru.job4j.profession;

public class Doctor extends Profession {
    private Diagnosis diagnosis;
    private Reception reception;

    public void reception(Pacient pacient) {
        System.out.println("У нас платный приём");
    }

    public void diagnosis(Pacient pacient) {
        System.out.println("Вы здоровы, с Вас 5000 у.е.");
    }
}
