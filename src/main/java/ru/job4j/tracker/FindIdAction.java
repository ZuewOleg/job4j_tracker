package ru.job4j.tracker;

public class FindIdAction implements UserAction{
    @Override
    public String name() {
        return "4. Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id : ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(id);
        } else {
            System.out.println("Application with this id was not found");
        }
        return true;
    }
}
