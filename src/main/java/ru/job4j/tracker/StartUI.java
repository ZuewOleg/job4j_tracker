package ru.job4j.tracker;

public class StartUI {

    public static void createItem (Input input, Tracker tracker) {
        System.out.println(" === Create a new Item === ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void addItem (Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item index : items) {
            System.out.println(index);
        }
    }

    public static void replaceItem (Input input, Tracker tracker) {
        int id = input.askInt("Enter id : ");
        String name = input.askStr("Enter name : ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("replacement was successful");
        } else {
            System.out.println("! ERROR ! element replacement is not implemented. " +
                    "perhaps an element with this id does not exist. try again.");
        }
    }

    public static void deleteItem (Input input, Tracker tracker) {
        int id = input.askInt("Enter id : ");
        if (tracker.delete(id)) {
            System.out.println("deletion was successful");
        } else {
            System.out.println("! ERROR ! element deletion is not implemented. " +
                    "perhaps an element with this id does not exist. try again.");
        }
    }

    public static void findIdItem (Input input, Tracker tracker) {
        int id = input.askInt("Enter id : ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(id);
        } else {
            System.out.println("Application with this id was not found");
        }
    }

    public static void findNameItem (Input input, Tracker tracker) {
        String name = input.askStr("Enter name : ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item index1 : items) {
                System.out.println(index1);
            }
        } else {
            System.out.println("Applications with this name were not found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.addItem(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findIdItem(input, tracker);
            } else if (select == 5) {
                StartUI.findNameItem(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
