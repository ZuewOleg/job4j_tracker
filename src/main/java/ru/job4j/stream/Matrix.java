package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public static List<Integer> arrayToList(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(e -> Stream.of(e))
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        System.out.println(
                matrix.stream()
                        .flatMap(e -> e.stream())
                        .collect(Collectors.toList())
        );
    }
}
