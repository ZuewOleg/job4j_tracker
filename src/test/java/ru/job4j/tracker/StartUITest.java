package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = Tracker.getInstance();
        List<Item> items = tracker.findAll();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllAction() {
       Output out = new StubOutput();
       Tracker tracker = Tracker.getInstance();
       List<Item> items = tracker.findAll();
               Input in = new StubInput(
               new String[] {"0", "1"}
       );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new AddAction(out));
        actions.add(new ExitAction(out));
       new StartUI(out).init(in, tracker, actions);
       assertThat(out.toString(), is(
               "Menu." + System.lineSeparator()
                       + "0. Show all items" + System.lineSeparator()
                       + "1. Exit Program" + System.lineSeparator()
                       + tracker.findAll() + System.lineSeparator()
                       + "Menu."
                       + System.lineSeparator()
                       + "0. Show all items" + System.lineSeparator()
                       + "1. Exit Program" + System.lineSeparator()
       ));
   }

   @Test
   public void whenFindByNameAction() {
       Output out = new StubOutput();
       Tracker tracker = Tracker.getInstance();
       List<Item> items = tracker.findByName("888");
       Input in = new StubInput(
               new String[]{"0", String.valueOf(items), "1"}
       );
       List<UserAction> actions = new ArrayList<>();
       actions.add(new FindNameAction(out));
       actions.add(new ExitAction(out));
       new StartUI(out).init(in, tracker, actions);
       assertThat(out.toString(), is(
               "Menu." + System.lineSeparator()
                       + "0. Find items by name" + System.lineSeparator()
                       + "1. Exit Program" + System.lineSeparator()
                       + "Applications with this name were not found"
                       + System.lineSeparator()
                       + "Menu."
                       + System.lineSeparator()
                       + "0. Find items by name" + System.lineSeparator()
                       + "1. Exit Program" + System.lineSeparator()
       ));
   }

   @Test
   public void whenFindByIdAction() {
       Output out = new StubOutput();
       Tracker tracker = Tracker.getInstance();
       Item item = tracker.add(new Item("Oleg"));
       Input in = new StubInput(
               new String[]{"0", String.valueOf(item.getId()), "1"}
       );
       List<UserAction> actions = new ArrayList<>();
       actions.add(new FindIdAction(out));
       actions.add(new ExitAction(out));
       new StartUI(out).init(in, tracker, actions);
       assertThat(out.toString(), is(
               "Menu." + System.lineSeparator()
                       + "0. Find item by Id" + System.lineSeparator()
                       + "1. Exit Program" + System.lineSeparator()
                       + (item.getId()) + System.lineSeparator()
                       + "Menu." + System.lineSeparator()
                       + "0. Find item by Id" + System.lineSeparator()
                       + "1. Exit Program" + System.lineSeparator()
       ));
   }

   @Test
   public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = Tracker.getInstance();
       List<UserAction> actions = new ArrayList<>();
       actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {
                        "1", "0"
                }
        );
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit Program%n"
                                + "Please enter validate data again.0%n"
                                + "Menu.%n"
                                + "0. Exit Program%n"
                )
        ));
    }
}