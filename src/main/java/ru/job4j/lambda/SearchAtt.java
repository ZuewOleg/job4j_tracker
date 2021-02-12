package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class SearchAtt {
    public static List<Attachment> filterSizeAndName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        UnaryOperator<List<Attachment>> func = new UnaryOperator<List<Attachment>>() {
            @Override
            public List<Attachment> apply(List<Attachment> list1) {
                for (Attachment att :list1) {
                    if (att.getSize() > 100 && att.getName().contains("bug")) {
                        rsl.add(att);
                    }
                }
                return rsl;
            }
        };
        return rsl;
    }
}
