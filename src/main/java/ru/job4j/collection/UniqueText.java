package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = false;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String originals : origin) { /* for-each origin -> new HashSet. */
            check.add(originals);
            String[] a = originals.split(originals);
            for (String texts : text) {/* for-each text -> hashSet.contains */
                if (originals.contains(texts)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }
}
