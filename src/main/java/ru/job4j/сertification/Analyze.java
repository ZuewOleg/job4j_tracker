package ru.job4j.сertification;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(), e.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(), e.getSubjects().stream()
                                .mapToInt(Subject::getScore)
                                .sum()))
                                .max(Comparator.comparingDouble(Tuple::getScore))
                                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
