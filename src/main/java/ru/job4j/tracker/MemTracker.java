package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public final class MemTracker {
    private static MemTracker instance = null;

    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;

    private MemTracker() {
    }

    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> keysWithoutNull = new ArrayList<>(items.size());
        int a = 0;
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                keysWithoutNull.add(item);
                a++;

            }
        }
        return keysWithoutNull;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
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
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}