package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Funkcion {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < end; i++) {
            rsl.add(func.apply((double) i));
        }
        return rsl;
    }

    public static List<Double> linefunc(int start, int end) {
            Function<Double, Double> func = x -> 2 * x + 1;
        return diapason(start, end, func);
    }

    public static List<Double> squarefunc(int start, int end) {
        Function<Double, Double> func = x -> Math.pow(x, 2D);
        return diapason(start, end, func);
    }

    public static List<Double> indicativefunc(int start, int end) {
        Function<Double, Double> func = x -> Math.pow(3, x);
        return diapason(start, end, func);
    }
}
