package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = left.compareTo(right);
        int size = Math.min(left.length(), right.length());
        char[] l = left.toCharArray();
        char[] r = right.toCharArray();
        for (int i = 0; i < size - 1; i++) {
            rsl = Character.compare(l[i], r[i]);
        }
        return rsl;
    }
}
