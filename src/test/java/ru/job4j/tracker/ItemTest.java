package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compareTo() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(6));
        items.add(new Item(2));
        items.add(new Item(5));
        Collections.sort(items);
        assertThat(items, is(items));
    }
}