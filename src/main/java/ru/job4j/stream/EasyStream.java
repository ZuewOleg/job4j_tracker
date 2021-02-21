package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    /** Нужно завести поле с типом List<Integer>
     * и писать в него результат работы промежуточных методов
     * и возвращать в качестве результата работы методов */
    private static List<Integer> stream;

    /** of - получает исходные данные */
    public static List<Integer> of(List<Integer> source) {
        for (var s : source) {
           stream.add(s);
        }
        return stream;
    }

    /** map - преобразует число в другое число */
    public List<Integer> map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>(stream);
        for (var st : stream) {
            rsl.add(fun.apply(st));
        }
        return rsl;
    }

    /** filter - фильтрует поток элементов */
    public List<Integer> filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>(stream);
        for (var st : stream) {
            if (fun.test(st)) {
                rsl.add(st);
            }
        }
        return rsl;
    }

    /** collect - собирает все элементы из source по заданным условиям map и filter */
    public List<Integer> collect() {
    }
}
