package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> loop(List<Attachment> list, Predicate<List<Attachment>> func) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (func.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<List<Attachment>> func = a -> a.getName().contains("bug");
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<List<Attachment>> func = a -> a.getSize() > 100;
    }

    return loop(list, func);
    }
}
