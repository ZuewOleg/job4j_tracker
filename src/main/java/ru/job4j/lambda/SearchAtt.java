package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> loop(List<Attachment> list, Predicate<List<Attachment>> func) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
                rsl.add(att);
        }
        return rsl;
    }

    public static List<Attachment> filterSizeAndName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        Predicate<List<Attachment>> func = new Predicate<List<Attachment>>() {
            @Override
            public boolean test(List<Attachment> attachments) {
                for (Attachment att : attachments) {
                    if (att.getSize() > 100 && att.getName().contains("bug")) {
                        rsl.add(att);
                    }
                }
                return true;
            }
        };
        return loop(list, func);
    }
}
