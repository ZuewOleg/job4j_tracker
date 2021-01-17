package ru.job4j.tracker;

public class FindNameAction implements UserAction {
    @Override
    public String name() {
        return "5. Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name : ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item index1 : items) {
                System.out.println(index1);
            }
        } else {
            System.out.println("Applications with this name were not found");
        }
        return true;
    }
}
