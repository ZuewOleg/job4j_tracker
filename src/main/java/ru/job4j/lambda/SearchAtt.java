package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> loop(List<Attachment> list, Predicate<List<Attachment>> func) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (func.test(list)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterSizeAndName(List<Attachment> list) {
        Predicate<List<Attachment>> func = new Predicate<List<Attachment>>() {
            @Override
            public boolean test(List<Attachment> attachments) {
                boolean rsl = false;
                for (Attachment att : attachments) {
                    if (att.getSize() > 100 && att.getName().contains("bug")) {
                        rsl = true;
                    }
                }
                return rsl;
            }
        };
        return loop(list, func);
    }
}
