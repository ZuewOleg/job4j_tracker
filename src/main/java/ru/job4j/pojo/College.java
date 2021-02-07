package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Zuev Oleg");
        student.setGroup("D-07");
        student.setReceipt(new Date());

        System.out.println(
                "Information about the student:" + System.lineSeparator() + "Name - "
                        +
                student.getName() + System.lineSeparator() + "Group - " + student.getGroup()
                        +
                System.lineSeparator() + "Date receipt - " + student.getReceipt()
        );
    }
}
