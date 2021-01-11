package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item != null) {
                itemsWithoutNull[size] = item;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        for (int i = 0; i < itemsWithoutNull.length; i++) {
            System.out.println(itemsWithoutNull[i]);
        }
        return items;
    }

        public Item[] findByName(String key) {
            Item[] keysWithoutNull = new Item[items.length];
            int a = 0;
            for (int index = 0; index < items.length; index++) {
                Item item = items[index];
                if (item.getName() == key) {
                    keysWithoutNull[a] = item;
                    a++;
                }
            }
                keysWithoutNull = Arrays.copyOf(keysWithoutNull, size);
                for (int i = 0; i < keysWithoutNull.length; i++) {
                    System.out.println(keysWithoutNull[i]);
                }
                return items;
            }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}