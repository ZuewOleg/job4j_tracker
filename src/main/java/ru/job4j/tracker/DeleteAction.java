package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "3. Delete item";
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
