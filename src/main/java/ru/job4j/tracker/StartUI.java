package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI extends ItemNew {

    public StartUI(LocalDateTime created) {
        super(created);
    }

    ItemNew itemNew = new ItemNew(getCreated());

    public static void main(String[] args) {
        LocalDateTime createdDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdDateTimeFormat = createdDateTime.format(formatter);
        System.out.println("Текущие дата и время: " + createdDateTime);
    }
}
