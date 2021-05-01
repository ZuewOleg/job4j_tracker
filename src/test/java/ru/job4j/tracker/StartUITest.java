package ru.job4j.tracker;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream(
                "app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("name"));
            boolean deleted = tracker.delete(item.getId());
            assertThat(deleted, is(true));
            assertThat(tracker.findByName("name").size(), is(0));
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    @Test
    public void findByNameAction() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("first"));
            tracker.add((new Item("second")));
            assertThat(tracker.findByName("second").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
