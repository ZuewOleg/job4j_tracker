package ru.job4j.tracker;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public final class Tracker {
    private static Tracker instance = null;

    private final ArrayList<Item> items = new ArrayList<>(100);
    private int ids = 1;
    private int size = 0;

    private Tracker() {}

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findAll() {
        return items.get(size);
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> keysWithoutNull = new ArrayList<>(items);
        int a = 0;
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                keysWithoutNull.add(a) = item;
                a++;
            }
        }
        return Arrays.copyOf(keysWithoutNull, a);
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.add(index) = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, index + 1, items, index, size - index);
            items.add(size - 1) = null;
            size--;
        }
        return rsl;
    }
}