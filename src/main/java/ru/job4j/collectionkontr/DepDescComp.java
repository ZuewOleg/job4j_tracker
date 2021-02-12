package ru.job4j.collectionkontr;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = o1.compareTo(o2);
        if (o1.equals(o2)) {
            rsl = o2.compareTo(o1);
        }
        return rsl;
    }
}
