package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compareToUp() {
        List<Item> items = Arrays.asList(
                new Item(6),
                new Item(2),
                new Item(5)
        );
        Collections.sort(items, new SortByIdItemUp());
        List<Item> expect = Arrays.asList(
                new Item(2),
                new Item(5),
                new Item(6)
        );
        assertThat(items, is(expect));
    }

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item("Oleg"),
                new Item("Ivan"),
                new Item("Petr")
        );
        Collections.sort(items, new SortByNameItem());
        List<Item> expect = Arrays.asList(
                new Item("Ivan"),
                new Item("Oleg"),
                new Item("Petr")
        );
        assertThat(items, is(expect));
    }

    @Test
    public void compareToDown() {
        List<Item> items = Arrays.asList(
                new Item(6),
                new Item(2),
                new Item(5)
        );
        Collections.sort(items, new SortByIdItemDown());
        List<Item> expect = Arrays.asList(
                new Item(6),
                new Item(5),
                new Item(2)
        );
        assertThat(items, is(expect));
    }
}