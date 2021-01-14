package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println(" === Create a new Item === ");
                System.out.println("Enter name : ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (Item index : items) {
                    System.out.println(index);
                }
            } else if (select == 2) {
                System.out.println("Enter id : ");
                int id = scanner.nextInt();
                System.out.println("Enter name : ");
                String name1 = scanner.nextLine();
                Item item = new Item(name1);
                if (tracker.replace(id, item)) {
                    System.out.println("replacement was successful");
                } else {
                    System.out.println("! ERROR ! element replacement is not implemented. " +
                            "perhaps an element with this id does not exist. try again.");
                }
            } else if (select == 3) {
                System.out.println("Enter id : ");
                int id = scanner.nextInt();
                if (tracker.delete(id)) {
                    System.out.println("deletion was successful");
                } else {
                    System.out.println("! ERROR ! element deletion is not implemented. " +
                            "perhaps an element with this id does not exist. try again.");
                }
            } else if (select == 4) {
                    System.out.println("Enter id : ");
                    int id = scanner.nextInt();
                    tracker.findById(id);
                    Item item = tracker.findById(id);
                    if (item != null) {
                        System.out.println(id);
                    } else {
                        System.out.println("Application with this id was not found");
                    }
            } else if (select == 5) {
                System.out.println("Enter name : ");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
