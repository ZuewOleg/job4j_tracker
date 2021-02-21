package ru.job4j.stream;

import java.util.*;
import java.util.function.*;

public class EasyStream {
    /** Нужно завести поле с типом List<Integer>
     * и писать в него результат работы промежуточных методов
     * и возвращать в качестве результата работы методов */
    private List<Integer> stream;

    /** чтобы запретить создание объектов класса вне этого класса */
    private EasyStream() {}

    /**  приватный конструктор, который будет инициализзировать поле
     * и соответсвенно с его помощью мы будем писать значение в наше добавленное поле
     */
    private EasyStream stream(List<Integer> stream) {
        this.stream = stream;
        return this;
    }

    @Override
    public String toString() {
        return "EasyStream{"
                +
                "stream=" + stream
                +
                '}';
    }

    /** of - получает исходные данные */
    public static EasyStream of(List<Integer> source) {
          EasyStream easyStream = new EasyStream().stream(source);
        return easyStream;
    }

    /** map - преобразует число в другое число */
    public EasyStream map(Function<Integer, Integer> fun) {
        EasyStream rsl = new EasyStream();
        for (var st : stream) {
            stream.add(fun.apply(st));
                rsl = new EasyStream().stream(stream);
            }
        return rsl;
    }

    /** filter - фильтрует поток элементов */
    public EasyStream filter(Predicate<Integer> fun) {
        EasyStream rsl = new EasyStream();
        for (var st : stream) {
            if (fun.test(st)) {
                stream.add(st);
            }
            rsl = new EasyStream().stream(stream);
        }
        return rsl;
    }

    /** collect - собирает все элементы из source по заданным условиям map и filter */
    public List<Integer> collect() {
        List<Integer> rsl = new ArrayList<>();
        for (var s : stream) {
            rsl.add(s);
        }
        return rsl;
    }
}
