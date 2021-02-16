package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamInteger {
    public static class Integer {
        private final int numb;

        public Integer(int numb) {
            this.numb = numb;
        }

        @Override
        public String toString() {
            return "Integer{"
                    + "numb=" + numb
                    + '}';
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
                numbers.add(new Integer(2));
                numbers.add(new Integer(5));
                numbers.add(new Integer(16));
                numbers.add(new Integer(-2));
                numbers.add(new Integer(-13));
        List<Integer> positive = numbers.stream().filter(integer -> integer.numb > 0
        ).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
