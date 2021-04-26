package ru.job4j.tracker;

import java.util.List;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name : ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item index1 : items) {
                out.println(index1);
            }
        } else {
            out.println("Applications with this name were not found");
        }
        return true;
    }
}
