package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String originals : origin) { /* for-each origin -> new HashSet. */
            check.add(originals);
                for (String texts : text) {/* for-each text -> hashSet.contains */
                    if (check.contains(texts)) {
                        rsl = true;
                    } else {
                        rsl = false;
                    }
                }
            }
        return rsl;
    }
}
