package ru.job4j.tracker;

public class AddAction implements UserAction {
    private final Output out;

    public AddAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item index : items) {
            System.out.println(index);
        }
        return true;
    }
}
