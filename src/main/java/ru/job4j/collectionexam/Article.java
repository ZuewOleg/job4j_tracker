package ru.job4j.collectionexam;

import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] originText = origin.split("[ .!,]+");
        String[] lineText = line.split("[ .!,]+");
        HashSet<String> check = new HashSet<>();
        for (String original : originText) {
            check.add(original);
        }
            for (String text : lineText) {
                if (!check.contains(text)) {
                    rsl = false;
                }
            }
        return rsl;
    }
}
