package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            String msg = "Select: ";
            int select = Integer.valueOf(input.askStr(msg));
            if (select == 0) {
                System.out.println(" === Create a new Item === ");
                String msgname = "Enter name : ";
                String name = input.askStr(msgname);
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (Item index : items) {
                    System.out.println(index);
                }
            } else if (select == 2) {
                String msgid = "Enter id : ";
                int id = Integer.valueOf(input.askStr(msgid));
                String msgname = "Enter name : ";
                String name1 = input.askStr(msgname);
                Item item = new Item(name1);
                if (tracker.replace(id, item)) {
                    System.out.println("replacement was successful");
                } else {
                    System.out.println("! ERROR ! element replacement is not implemented. " +
                            "perhaps an element with this id does not exist. try again.");
                }
            } else if (select == 3) {
                String msgid = "Enter id : ";
                int id = Integer.valueOf(input.askStr(msgid));
                if (tracker.delete(id)) {
                    System.out.println("deletion was successful");
                } else {
                    System.out.println("! ERROR ! element deletion is not implemented. " +
                            "perhaps an element with this id does not exist. try again.");
                }
            } else if (select == 4) {
                String msgid = "Enter id : ";
                int id = Integer.valueOf(input.askInt(msgid));
                    tracker.findById(id);
                    Item item = tracker.findById(id);
                    if (item != null) {
                        System.out.println(id);
                    } else {
                        System.out.println("Application with this id was not found");
                    }
            } else if (select == 5) {
                String msgname = "Enter name : ";
                String name = input.askStr(msgname);
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item index1 : items) {
                        System.out.println(index1);
                    }
                } else {
                    System.out.println("Applications with this name were not found");
                }
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
