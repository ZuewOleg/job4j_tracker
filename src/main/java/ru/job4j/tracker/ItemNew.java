package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItemNew {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public LocalDateTime getCreated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdFormat = created.format(formatter);
        System.out.println(createdFormat);
        return created;
    }
}
