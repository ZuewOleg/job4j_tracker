package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

   @Test
   public void whenFindAllAction() {
       Output out = new StubOutput();
       Input in = new StubInput(
               new String[] {"0", "1", "2", "3"}
       );
       Tracker tracker = new Tracker();
       UserAction[] actions = {
               new AddAction(out), new FindIdAction(out),
               new FindNameAction(out), new ExitAction(out)
       };
       new StartUI(out).init(in, tracker, actions);
       assertThat(out.toString(), is(
               "Menu." + System.lineSeparator() +
                       "0. Show all items" + System.lineSeparator() +
                       "1. Find item by Id" + System.lineSeparator() +
                       "2. Find items by name" + System.lineSeparator() +
                       "3. Exit Program" + System.lineSeparator() +
                       "Menu." + System.lineSeparator() +
                       "0. Show all items" + System.lineSeparator() +
                       "1. Find item by Id" + System.lineSeparator() +
                       "2. Find items by name" + System.lineSeparator() +
                       "3. Exit Program" + System.lineSeparator() +
                       "Menu." + System.lineSeparator() +
                       "0. Show all items" + System.lineSeparator() +
                       "1. Find item by Id" + System.lineSeparator() +
                       "2. Find items by name" + System.lineSeparator() +
                       "3. Exit Program" + System.lineSeparator()
       ));
   }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator()
        ));
    }
}