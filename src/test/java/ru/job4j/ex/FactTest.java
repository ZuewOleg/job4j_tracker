package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test
    public void whetFactorial7to5040() {
        int rsl = Fact.calc(7);
        assertThat(rsl, is (5040));
    }

}