package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int size = Math.max(left.length(), right.length());
        for (int i = 0; i < size - 1; i++) {
            rsl = Integer.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                break;
            } else {
                rsl = Integer.compare(left.length(), right.length());
            }
        }
        return rsl;
    }
}
