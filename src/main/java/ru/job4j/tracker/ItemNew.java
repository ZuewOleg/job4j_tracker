package ru.job4j.tracker;

public class ItemNew {
    private int id;
    private String name;

    public ItemNew() {
    }

    public ItemNew(int id) {
        this.id = id;
    }

    public ItemNew(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        ItemNew item = new ItemNew(1, "Oleg");
    }
}
