package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MatrixTest {

    @Test
    public void arrayToList() {
        Integer[][] a = {
                {2, 3},
                {1, 4},
        };
        List<Integer> rsl = Matrix.arrayToList(a);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        assertThat(rsl, is(expected));
    }
}