package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<StudentNew> input = new ArrayList<>();
        input.add(new StudentNew(28, "Masha"));
        input.add(new StudentNew(128, "Pety"));
        List<StudentNew> expected = List.of(
                new StudentNew(128, "Pety"),
                new StudentNew(28, "Masha")
        );
        assertThat(StudentLevel.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<StudentNew> input = new ArrayList<>();
        input.add( null);
        List<StudentNew> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<StudentNew> input = new ArrayList<>();
        input.add( null);
        input.add(new StudentNew(28,"Pety"));
        List<StudentNew> expected = List.of(new StudentNew(28,"Pety"));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }
}