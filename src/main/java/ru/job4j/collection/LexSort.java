package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] l = left.split("\\.");
        String[] r = right.split("\\.");
        int lft = Integer.parseInt(l[0]);
        int rgt = Integer.parseInt(r[0]);
        if (lft < rgt) {
            rsl = Integer.compare(lft, rgt);
        }
        return rsl;
    }
}
