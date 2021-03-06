package ru.job4j.tracker;

import java.sql.SQLException;

public class FindIdAction implements UserAction {
    private final Output out;

    public FindIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        int id = input.askInt("Enter id : ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(id);
        } else {
            out.println("Application with this id was not found");
        }
        return true;
    }
}
