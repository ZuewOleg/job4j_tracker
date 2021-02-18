package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<StudentNew> levelOf(List<StudentNew> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted((l, r) -> Integer.compare(r.getScore(), l.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
