package ru.job4j.tracker;

public class StartUI extends ItemNew {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item(1, "first");
        tracker.add(item);
        tracker.findById(1);
        System.out.println(tracker.findById(1));
    }
}
