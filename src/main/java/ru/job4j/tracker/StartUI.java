package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) throws SQLException {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Please enter validate data again." + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input validate = new ValidateInput(new ConsoleOutput(), new ConsoleInput());
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction(new ConsoleOutput()));
            actions.add(new DeleteAction(new ConsoleOutput()));
            actions.add(new ReplaceAction(new ConsoleOutput()));
            actions.add(new AddAction(new ConsoleOutput()));
            actions.add(new FindNameAction(new ConsoleOutput()));
            actions.add(new FindIdAction(new ConsoleOutput()));
            actions.add(new ExitAction(new ConsoleOutput()));

            new StartUI(new ConsoleOutput()).init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
