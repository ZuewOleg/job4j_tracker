package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id : ");
        if (tracker.delete(id)) {
            System.out.println("deletion was successful");
        } else {
            System.out.println("! ERROR ! element deletion is not implemented. " +
                    "perhaps an element with this id does not exist. try again.");
        }
        return true;
    }
}
