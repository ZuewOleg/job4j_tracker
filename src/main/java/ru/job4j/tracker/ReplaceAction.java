package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id : ");
        String name = input.askStr("Enter name : ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("replacement was successful");
        } else {
            out.println("! ERROR ! element replacement is not implemented. "
                    +
                    "perhaps an element with this id does not exist. try again.");
        }
        return true;
    }
}
