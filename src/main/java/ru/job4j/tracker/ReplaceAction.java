package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "2. Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id : ");
        String name = input.askStr("Enter name : ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("replacement was successful");
        } else {
            System.out.println("! ERROR ! element replacement is not implemented. " +
                    "perhaps an element with this id does not exist. try again.");
        }
        return true;
    }
}
