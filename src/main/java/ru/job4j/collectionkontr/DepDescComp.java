package ru.job4j.collectionkontr;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        String a = first[0];
        String b = second[0];
        int rsl = b.compareTo(a);
        if (rsl == 0) {
            rsl = o1.compareTo(o2);
        }
        return rsl;
    }
}
