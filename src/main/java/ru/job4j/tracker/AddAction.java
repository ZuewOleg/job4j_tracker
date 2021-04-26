package ru.job4j.tracker;

import java.util.List;

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
    public boolean execute(Input input, Store tracker) {
        List<Item> items = tracker.findAll();
        for (Object index : items) {
            out.println(index);
        }
        return true;
    }
}
